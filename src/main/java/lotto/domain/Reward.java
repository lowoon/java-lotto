package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Reward {
    private static final Map<Rank, Integer> rewards;

    static {
        rewards = new TreeMap<>();
        rewards.putIfAbsent(Rank.FIRST, 2_000_000_000);
        rewards.putIfAbsent(Rank.SECOND, 30_000_000);
        rewards.putIfAbsent(Rank.THIRD, 1_500_000);
        rewards.putIfAbsent(Rank.FOURTH, 50_000);
        rewards.putIfAbsent(Rank.FIFTH, 5_000);
        rewards.putIfAbsent(Rank.NONE, 0);
    }

    private final Map<Rank, Integer> countOfRanks;

    private Reward(Map<Rank, Integer> countOfRanks) {
        this.countOfRanks = countOfRanks;
    }

    public static Reward from(Map<Rank, Integer> countOfRanks) {
        return new Reward(countOfRanks);
    }

    public int calculateProfit(Money money) {
        int reward = countOfRanks.entrySet()
            .stream()
            .mapToInt(entry -> entry.getValue() * rewards.get(entry.getKey()))
            .sum();

        return money.calculateProfit(reward);
    }

    public Map<Rank, Integer> getCountOfRanks() {
        return Collections.unmodifiableMap(new TreeMap<>(countOfRanks));
    }

    public Map<Rank, Integer> getValues() {
        return Collections.unmodifiableMap(new TreeMap<>(rewards));
    }
}
