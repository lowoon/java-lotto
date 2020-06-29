package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStrategy implements GenerateStrategy {
    public static final int FIRST_INDEX = 0;

    private static final List<Integer> numbers;

    static {
        numbers = IntStream.range(LottoNumber.MIN, LottoNumber.MAX + 1)
            .boxed()
            .collect(Collectors.toList());
    }

    @Override
    public Lotto generate() {
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(FIRST_INDEX, Lotto.COUNT_OF_LOTTO_NUMBER);
        return Lotto.of(lottoNumbers);
    }
}
