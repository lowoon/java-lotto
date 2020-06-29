package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RewardTest {
    @ParameterizedTest
    @MethodSource("createRankAndReward")
    void of(int countOfMatch, boolean matchBonus, int expected) {
        assertThat(Reward.of(countOfMatch, matchBonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> createRankAndReward() {
        return Stream.of(
            Arguments.of(6, true, 2_000_000_000),
            Arguments.of(5, true, 30_000_000),
            Arguments.of(5, false, 1_500_000),
            Arguments.of(4, false, 50_000),
            Arguments.of(3, true, 5_000),
            Arguments.of(2, false, 0),
            Arguments.of(1, true, 0),
            Arguments.of(0, false, 0)
        );
    }
}
