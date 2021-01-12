package lotto.domain;

import lotto.util.MatchResult;
import lotto.util.Rank;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public static Lotto of(Set<LottoNumber> lottoNumbers) {
        Set<LottoNumber> newLottoNumbers = new TreeSet<>(
                Comparator.comparingInt(LottoNumber::getNumber));
        newLottoNumbers.addAll(lottoNumbers);
        return new Lotto(newLottoNumbers);
    }

    public Rank match(MatchNumber matchNumber) {
        int winCount = (int) lottoNumbers.stream()
                .map(matchNumber::getMatchResult)
                .filter(matchResult -> matchResult.equals(MatchResult.WIN))
                .count();
        int bonusCount = (int) lottoNumbers.stream()
                .map(matchNumber::getMatchResult)
                .filter(matchResult -> matchResult.equals(MatchResult.BONUS))
                .count();
        return Rank.of(winCount, bonusCount);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream().map(LottoNumber::getNumber)
                .map(no -> Integer.toString(no))
                .collect(Collectors.joining(", ")) + "]";
    }
}
