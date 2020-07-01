package lotto;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Reward;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        Money money = Money.from(InputView.receiveMoney());
        Lottos lottos = lottoService.createLottos(money);
        OutputView.printResultOfLottos(lottos.getLottos());

        WinningLotto winningLotto = lottoService.createWinningLotto(InputView.receiveLotto(),
            InputView.receiveBonusNumber());
        Reward reward = Reward.from(lottos.countOfRank(winningLotto));
        OutputView.printResultCountOfRanks(reward.getCountOfRanks(), reward.getValues());
        OutputView.printProfit(reward.calculateProfit(money));
    }
}
