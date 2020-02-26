package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.count.Count;

class LottoFactoryTest {

    @Test
    @DisplayName("LottoTicketFactory는 money를 받아 lottoTicket을 발행")
    void lottoTicketFactoryPublishsLottoTickets() {
        Count count = new Count(10, 4);
        LottoTickets lottoTickets = LottoFactory.publishLottoTickets(count);
    }
}