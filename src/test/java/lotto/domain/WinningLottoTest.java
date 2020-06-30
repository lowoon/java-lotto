package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.InvalidBonusNumberException;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호 중에 보너스 번호와 같은 번호가 있는 경우")
    void winningLottoWithDuplicateBonusNumber() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
        LottoNumber lottoNumber = LottoNumber.valueOf(6);

        assertThatThrownBy(() -> WinningLotto.of(lotto, lottoNumber))
            .isInstanceOf(InvalidBonusNumberException.class)
            .hasMessage("당첨 번호 중 보너스 번호와 같은 번호가 있습니다.");
    }
}
