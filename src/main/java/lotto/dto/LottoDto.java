package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {
    private final List<Integer> lotto;

    public LottoDto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static LottoDto from(Lotto lottoObj) {
        return new LottoDto(lottoObj.getLottoNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList()));
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
