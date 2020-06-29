package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.InvalidLottoNumberException;

class LottoNumberTest {

    @Test
    @DisplayName("숫자에 맞는 로또넘버")
    void valueOf() {
        LottoNumber lottoNumber = LottoNumber.valueOf(1);

        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("최소 숫자보다 작은 로또넘버")
    void valueOfUnderMin() {
        assertThatThrownBy(() -> LottoNumber.valueOf(0))
            .isInstanceOf(InvalidLottoNumberException.class)
            .hasMessage("로또 넘버는 1보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("최대 숫자보다 큰 로또넘버")
    void valueOfOverMax() {
        assertThatThrownBy(() -> LottoNumber.valueOf(46))
            .isInstanceOf(InvalidLottoNumberException.class)
            .hasMessage("로또 넘버는 45보다 클 수 없습니다.");
    }
}
