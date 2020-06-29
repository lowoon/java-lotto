package lotto.domain;

import java.util.Arrays;

import lotto.exception.InvalidCountOfMatch;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private final int countOfMatch;
    private final boolean matchBonus;

    Rank(int countOfMatch, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public static Rank from(int countOfMatch, boolean matchBonus) {
        validate(countOfMatch);
        boolean actual = BonusMatcher.matchBonus(countOfMatch, matchBonus);

        return Arrays.stream(values())
            .filter(rank -> rank.countOfMatch == countOfMatch)
            .filter(rank -> rank.matchBonus == actual)
            .findFirst()
            .orElse(NONE);
    }

    private static void validate(int countOfMatch) {
        if (countOfMatch > 6) {
            throw new InvalidCountOfMatch("일치한 로또 넘버가 6보다 클 수 없습니다.");
        }
        if (countOfMatch < 0) {
            throw new InvalidCountOfMatch("일치한 로또 넘버가 0보다 작을 수 없습니다.");
        }
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean matchBonus() {
        return matchBonus;
    }
}
