package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.exception.InvalidCountOfMatchException;

class RankTest {
    @ParameterizedTest
    @MethodSource("createMatchCountAntMatchBonus")
    @DisplayName("로또 번호 일치 개수와 보너스 번호 일치 여부에 맞는 순위")
    void from(int countOfMatch, boolean matchBonus, boolean expected) {
        Rank rank = Rank.from(countOfMatch, matchBonus);

        assertThat(rank.matchBonus()).isEqualTo(expected);
    }

    private static Stream<Arguments> createMatchCountAntMatchBonus() {
        return Stream.of(
            Arguments.of(6, true, false),
            Arguments.of(5, true, true),
            Arguments.of(6, false, false)
        );
    }

    @Test
    @DisplayName("일차한 로또 번호가 최대값보다 큰 경우")
    void fromOverMaxCountOfMatch() {
        assertThatThrownBy(() -> Rank.from(7, false))
            .isInstanceOf(InvalidCountOfMatchException.class)
            .hasMessage("일치한 로또 번호가 6보다 클 수 없습니다.");
    }

    @Test
    @DisplayName("일치한 로또 번호가 최소값보다 작은 경우")
    void fromUnderMinCountOfMatch() {
        assertThatThrownBy(() -> Rank.from(-1, false))
            .isInstanceOf(InvalidCountOfMatchException.class)
            .hasMessage("일치한 로또 번호가 0보다 작을 수 없습니다.");
    }
}
