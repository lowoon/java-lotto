package lotto.domain;

import java.util.Map;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false,50_000),
    FIFTH(3, false, );

    private final int matchCount;
    private final boolean matchBonus;
    private final int reward;

    Rank(int matchCount, boolean matchBonus, int reward) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
    }

    public static int rewardOf(int matchCount, boolean matchBonus) {
        return
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
