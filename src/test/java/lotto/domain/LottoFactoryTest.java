package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @Test
    @DisplayName("로또 생성")
    void generate() {
        List<Integer> numbers = Arrays.asList(2,3,4,5,6,7);
        LottoFactory lottoFactory = new LottoFactory(new TestStrategy(numbers));

        Lotto lotto = lottoFactory.generateLotto();

        assertThat(lotto).isEqualTo(Lotto.of(numbers));
    }
}
