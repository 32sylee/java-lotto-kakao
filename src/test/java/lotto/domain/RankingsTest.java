package lotto.domain;

import lotto.util.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingsTest {
    Rankings rankings;

    @BeforeEach
    void setUp(){
        List<Rank> ranks = List.of(Rank.SECOND, Rank.FOURTH, Rank.FIFTH);
        rankings = Rankings.fromRanks(ranks);
    }

    @Test
    @DisplayName("수익률을 계산하여 반환한다.")
    void profitTest(){
        assertThat(rankings.getProfitRate(new Money(14000))).isEqualTo(214678);
    }
}
