package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Reward {
    private static final Map<Rank, Integer> rewards;

    static {
        rewards = new HashMap<>();
        rewards.putIfAbsent(Rank.FIRST, 2_000_000_000);
        rewards.putIfAbsent(Rank.SECOND, 30_000_000);
        rewards.putIfAbsent(Rank.THIRD, 1_500_000);
        rewards.putIfAbsent(Rank.FOURTH, 50_000);
        rewards.putIfAbsent(Rank.FIFTH, 5_000);
        rewards.putIfAbsent(Rank.NONE, 0);
    }

    public static int of(int matchCount, boolean matchBonus) {
        return rewards.get(Rank.from(matchCount, matchBonus));
    }
}
