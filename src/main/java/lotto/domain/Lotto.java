package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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

    public int countOfMatch(WinningLotto winningLotto) {
        return (int)lotto.stream()
            .filter(winningLotto::contains)
            .count();
    }

    public boolean matchBonus(WinningLotto winningLotto) {
        return lotto.contains(winningLotto.getBonusNumber());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> listOfSortedLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto);
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(new HashSet<>(lotto));
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
