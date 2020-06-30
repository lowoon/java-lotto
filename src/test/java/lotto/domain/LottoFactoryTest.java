package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @Test
    @DisplayName("랜덤 로또 생성")
    void generateRandomLotto() {
        List<Integer> numbers = Arrays.asList(2,3,4,5,6,7);
        LottoFactory lottoFactory = new LottoFactory(new TestStrategy(numbers));

        Lotto lotto = lottoFactory.generateRandomLotto();

        assertThat(lotto).isEqualTo(Lotto.of(numbers));
    }

    @Test
    @DisplayName("로또 생성")
    void generateLotto() {
        List<Integer> numbers = Arrays.asList(2,3,4,5,6,7);
        LottoFactory lottoFactory = new LottoFactory(new TestStrategy(numbers));

        Lotto lotto = lottoFactory.generateLotto(numbers);

        assertThat(lotto).isEqualTo(Lotto.of(numbers));
    }
}
