package lotto.domain;

import java.util.Arrays;

import lotto.exception.InvalidCountOfMatchException;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private static final int MAX = 6;
    private static final int MIN = 0;

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
        if (countOfMatch > MAX) {
            throw new InvalidCountOfMatchException("일치한 로또 번호가 " + MAX + "보다 클 수 없습니다.");
        }
        if (countOfMatch < MIN) {
            throw new InvalidCountOfMatchException("일치한 로또 번호가 " + MIN + "보다 작을 수 없습니다.");
        }
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean matchBonus() {
        return matchBonus;
    }
}
