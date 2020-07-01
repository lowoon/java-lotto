package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public static void printResultOfLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매 했습니다");
        for (Lotto lotto : lottos) {
            String result = lotto.listOfSortedLottoNumbers()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(", "));
            System.out.println("[" + result + "]");
        }
        System.out.println();
    }

    public static void printResultCountOfRanks(Map<Rank, Integer> countOfRanks, Map<Rank, Integer> rewards) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        String result = countOfRanks.entrySet()
            .stream()
            .map(entry -> {
                if (entry.getKey().isSecond()) {
                    return entry.getKey().getCountOfMatch() + "개 일치, 보너스볼 일 (" +
                        rewards.get(entry.getKey()) + "원) - " + entry.getValue() + "개";
                }
                return entry.getKey().getCountOfMatch() + "개 일치 (" +
                    rewards.get(entry.getKey()) + "원) - " + entry.getValue() + "개";
            })
            .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    public static void printProfit(int profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
