package lotto.domain;

public class LottoFactory {
    private final GenerateStrategy generateStrategy;

    public LottoFactory(GenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public Lotto generateLotto() {
        return generateStrategy.generate();
    }
}
