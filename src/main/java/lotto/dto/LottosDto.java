package lotto.dto;

import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosDto {

    private final List<LottoDto> lottoDtos;

    public LottosDto(List<LottoDto> lottoDtos) {
        this.lottoDtos = lottoDtos;
    }

    public static LottosDto from(Lottos lottosObj) {
        return new LottosDto(lottosObj.getLottos()
                .stream()
                .map(LottoDto::from)
                .collect(Collectors.toList()));
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }
}
