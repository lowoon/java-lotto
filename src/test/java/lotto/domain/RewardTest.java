package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TransferQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RewardTest {
    @ParameterizedTest
    @MethodSource("createRankAndCount")
    @DisplayName("당첨 금액에 따른 수익률")
    void calculateProfit(Rank rank, int expected) {
        Map<Rank, Integer> countOfRanks = Arrays.stream(Rank.values())
            .collect(Collectors.toMap(r -> r, r -> 0, (v1, v2) -> v1, TreeMap::new));
        countOfRanks.compute(rank, (k, v) -> v + 1);

        Money money = Money.from(5000);
        Reward reward = Reward.from(countOfRanks);

        assertThat(reward.calculateProfit(money)).isEqualTo(expected);
    }

    private static Stream<Arguments> createRankAndCount() {
        return Stream.of(
            Arguments.of(Rank.FIFTH, 0),
            Arguments.of(Rank.FOURTH, 900),
            Arguments.of(Rank.THIRD, 29900)
        );
    }
}
