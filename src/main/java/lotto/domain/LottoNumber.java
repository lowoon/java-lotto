package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    private static class LottoNumberCache {
        static final int low = 1;
        static final int high = 45;
        static final LottoNumber[] cache = new LottoNumber[low + high];

        static {
            for (int i = low; i <= high; i++) {
                cache[i] = new LottoNumber(i);
            }
        }

    }

    public static LottoNumber valueOf(int number) {
        if (number < LottoNumberCache.low) {
            throw new InvalidLottoNumberException("로또 넘버는 " + LottoNumberCache.low + "보다 작을 수 없습니다.");
        }
        if (number > LottoNumberCache.high) {
            throw new InvalidLottoNumberException("로또 넘버는 " + LottoNumberCache.high + "보다 클 수 없습니다.");
        }
        return LottoNumberCache.cache[number];
    }

    public int getNumber() {
        return number;
    }
}
