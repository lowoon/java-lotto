package lotto.domain;

import lotto.exception.InvalidBonusNumberException;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new InvalidBonusNumberException("당첨 번호 중 보너스 번호와 같은 번호가 있습니다.");
        }
    }

    public static WinningLotto of(Lotto lotto, LottoNumber lottoNumber) {
        return new WinningLotto(lotto, lottoNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
