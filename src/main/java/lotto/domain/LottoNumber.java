package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MAX = 45;
    public static final int MIN = 1;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    private static class LottoNumberCache {

        static final LottoNumber[] cache = new LottoNumber[MIN + MAX];
        static {
            for (int i = MIN; i <= MAX; i++) {
                cache[i] = new LottoNumber(i);
            }
        }

    }
    public static LottoNumber valueOf(int number) {
        if (number < MIN) {
            throw new InvalidLottoNumberException("로또 번호는 " + MIN + "보다 작을 수 없습니다.");
        }
        if (number > MAX) {
            throw new InvalidLottoNumberException("로또 번호는 " + MAX + "보다 클 수 없습니다.");
        }
        return LottoNumberCache.cache[number];
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }
}
