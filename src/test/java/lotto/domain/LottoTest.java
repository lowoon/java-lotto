package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.InvalidLottoException;

class LottoTest {
    @Test
    @DisplayName("로또의 숫자가 6개가 아닌 경우")
    void lottoWithInvalidNumbers() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1,2,3,2,1)))
            .isInstanceOf(InvalidLottoException.class)
            .hasMessage("한 개의 로또는 6개의 다른 숫자여야 합니다.");
    }
}
