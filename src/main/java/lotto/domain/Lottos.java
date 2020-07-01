package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Map<Rank, Integer> countOfRank(WinningLotto winningLotto) {
        Map<Rank, Integer> countOfRanks = Arrays.stream(Rank.values())
            .collect(Collectors.toMap(rank -> rank, rank -> 0, (v1, v2) -> v1, TreeMap::new));

        for (Lotto lotto : lottos) {
            int countOfMatch = lotto.countOfMatch(winningLotto);
            boolean matchBonus = lotto.matchBonus(winningLotto);
            countOfRanks.computeIfPresent(Rank.from(countOfMatch, matchBonus),
                (key, value) -> value + 1);
        }

        return countOfRanks;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(new ArrayList<>(lottos));
    }
}
