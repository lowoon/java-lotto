package lotto.domain;

public class Money {
    public static int LOTTO_PRICE = 1_000;

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(String money) {
        return new Money(Integer.parseInt(money));
    }

    public int countOfLotto() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
