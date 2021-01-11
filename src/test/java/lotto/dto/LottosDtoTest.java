package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosDtoTest {

    @Test
    @DisplayName("Lottos와 동일한 값을 가지는 LottosDto를 생성한다.")
    void create() {
        Lottos lottos = Lottos.fromMoney(new Money(2000), new RandomNumberGenerator());
        LottosDto lottosDto = LottosDto.from(lottos);

        List<Integer> actual = lottosDto.getLottoDtos().stream()
                .flatMap(lottoDto -> lottoDto.getLotto().stream())
                .collect(Collectors.toList());
        List<Integer> expected = lottos.getLottos().stream()
                .flatMap(lotto -> {
                    return lotto.getLottoNumbers()
                            .stream()
                            .map(LottoNumber::getNumber);
                }).collect(Collectors.toList());
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
