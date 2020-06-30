package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("구매 금액에 맞는 로또 개수")
    void countOfLotto() {
        Money money = Money.from("1000");

        assertThat(money.countOfLotto()).isEqualTo(1);
    }
}
