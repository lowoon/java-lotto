package lotto.domain;

import java.util.List;

public class TestStrategy implements GenerateStrategy {
    private final List<Integer> numbers;

    public TestStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generate() {
        return Lotto.of(numbers);
    }
}
