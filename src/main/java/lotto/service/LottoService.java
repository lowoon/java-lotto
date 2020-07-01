package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomStrategy;
import lotto.domain.WinningLotto;

public class LottoService {
    private static final LottoFactory lottoFactory = new LottoFactory(new RandomStrategy());

    public Lottos createLottos(Money money) {
        int countOfLotto = money.countOfLotto();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(lottoFactory.generateRandomLotto());
        }

        return Lottos.from(lottos);
    }

    public WinningLotto createWinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        return WinningLotto.of(lottoFactory.generateLotto(lottoNumbers),
            LottoNumber.valueOf(bonusNumber));
    }
}
