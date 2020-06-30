package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {
    @ParameterizedTest
    @MethodSource("createLottoAndCountOfRank")
    @DisplayName("순위별 개수")
    void countOfRank(List<Integer> list, Rank rank) {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
        LottoNumber lottoNumber = LottoNumber.valueOf(7);
        WinningLotto winningLotto = WinningLotto.of(lotto, lottoNumber);

        Lottos lottos = Lottos.from(Collections.singletonList(Lotto.of(list)));

        assertThat(lottos.countOfRank(winningLotto).get(rank)).isEqualTo(1);
    }

    private static Stream<Arguments> createLottoAndCountOfRank() {
        return Stream.of(
            Arguments.of(Arrays.asList(1,2,3,4,5,6), Rank.FIRST),
            Arguments.of(Arrays.asList(1,2,3,4,5,7), Rank.SECOND),
            Arguments.of(Arrays.asList(1,2,3,4,5,8), Rank.THIRD),
            Arguments.of(Arrays.asList(3,4,5,6,7,8), Rank.FOURTH),
            Arguments.of(Arrays.asList(4,5,6,7,8,9), Rank.FIFTH)
        );
    }
}
