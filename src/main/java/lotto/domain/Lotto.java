package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.exception.InvalidLottoException;

public class Lotto {
    public static final int COUNT_OF_LOTTO_NUMBER = 6;

    private final Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    private void validate(Set<LottoNumber> lotto) {
        if (lotto.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new InvalidLottoException("한 개의 로또는 6개의 다른 숫자여야 합니다.");
        }
    }

    public static Lotto of(List<Integer> lotto) {
        return new Lotto(lotto.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toSet()));
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Lotto lotto1 = (Lotto)o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
