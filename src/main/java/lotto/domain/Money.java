package lotto.domain;

public class Money {
    public static int LOTTO_PRICE = 1_000;

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int countOfLotto() {
        return money / LOTTO_PRICE;
    }

    public int calculateProfit(int reward) {
        return ((reward - money) / money) * 100;
    }

    public int getMoney() {
        return money;
    }
}
