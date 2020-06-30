package lotto.domain;

import java.util.List;

public class LottoFactory {
    private final GenerateStrategy generateStrategy;

    public LottoFactory(GenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public Lotto generateRandomLotto() {
        return generateStrategy.generate();
    }

    public Lotto generateLotto(List<Integer> lottoNumbers) {
        return Lotto.of(lottoNumbers);
    }
}
