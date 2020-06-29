package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum BonusMatcher {
    SECOND(5, b -> b),
    ELSE(0, b -> false);

    private final int matchCount;
    private final Function<Boolean, Boolean> bonusMatcher;

    BonusMatcher(int matchCount, Function<Boolean, Boolean> bonusMatcher) {
        this.matchCount = matchCount;
        this.bonusMatcher = bonusMatcher;
    }

    public static boolean matchBonus(int matchCount, boolean matchBonus) {
        return Arrays.stream(BonusMatcher.values())
            .filter(bonusMatcher -> bonusMatcher.matchCount == matchCount)
            .findFirst()
            .orElse(BonusMatcher.ELSE)
            .bonusMatcher.apply(matchBonus);
    }
}
