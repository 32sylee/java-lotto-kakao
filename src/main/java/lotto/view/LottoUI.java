package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankingsDto;
import lotto.util.Rank;

import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoUI {
    private final Scanner scanner;

    public LottoUI() {
        scanner = new Scanner(System.in);
    }

    public int getMoneyFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printLottos(LottosDto lottosDto) {
        System.out.println(lottosDto.getLottoDtos().size() + "개를 구매했습니다.");
        for (LottoDto lottoDto : lottosDto.getLottoDtos()) {
            printLotto(lottoDto);
        }
    }

    private void printLotto(LottoDto lottoDto) {
        System.out.println("[" + lottoDto.getLotto()
                .stream()
                .map(LottoNumberDto -> Integer.toString(LottoNumberDto))
                .collect(Collectors.joining(", ")) + "]");
    }

    public String getWinningNumberFromUser() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int getBonusNumberFromUser() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printStatistics(RankingsDto rankingsDto) {
        System.out.println("당첨 통계\n---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", rankingsDto.getRankings().get(Rank.FIFTH));
        System.out.printf("4개 일치 (50000원)- %d개\n",  rankingsDto.getRankings().get(Rank.FOURTH));
        System.out.printf("5개 일치 (1500000원)- %d개\n",  rankingsDto.getRankings().get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개\n",  rankingsDto.getRankings().get(Rank.SECOND));
        System.out.printf("6개 일치 (2000000000원)- %d개\n",  rankingsDto.getRankings().get(Rank.FIRST));
    }

    public void printProfitRate(int profitRate) {
        System.out.printf("총 수익률은 %d%% 입니다.\n", profitRate);
    }
}
