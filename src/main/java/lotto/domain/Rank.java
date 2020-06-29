package lotto.domain;

import java.util.Objects;

public class Rank {
    private final int matchCount;
    private final boolean matchBonus;

    private Rank(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static Rank from(int matchCount, boolean matchBonus) {
        return new Rank(matchCount, BonusMatcher.matchBonus(matchCount, matchBonus));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean matchesBonus() {
        return matchBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rank rank = (Rank)o;
        return matchCount == rank.matchCount &&
            matchBonus == rank.matchBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, matchBonus);
    }
}
