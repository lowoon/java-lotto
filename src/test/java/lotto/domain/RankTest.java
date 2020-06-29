package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
    @ParameterizedTest
    @MethodSource("createMatchCountAntMatchBonus")
    @DisplayName("로또 번호 일치 개수와 보너스 번호 일치 여부에 맞는 순위")
    void from(int matchCount, boolean matchBonus, boolean expected) {
        Rank rank = Rank.from(matchCount, matchBonus);

        assertThat(rank.matchesBonus()).isEqualTo(expected);
    }

    private static Stream<Arguments> createMatchCountAntMatchBonus() {
        return Stream.of(
            Arguments.of(6, true, false),
            Arguments.of(5, true, true),
            Arguments.of(6, false, false)
        );
    }
}
