package lotto;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import view.Printable;

public class LottoResults implements Printable {
    private static final String NEW_LINE = "\n";
    private static final String LOTTO_RESULTS_MESSAGE_FORMAT = "%s- %d개";

    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoResults)) {
            return false;
        }
        LottoResults that = (LottoResults)o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }

    public EarningRate calculateEarningRate() {
        return LottoMoney.calculateEarningRate(lottoResults.stream().map(LottoResult::getLottoMoney).collect(toList()));
    }

    @Override
    public String makePrintableMessage() {
        Map<LottoResult, Integer> resultCounts = lottoResults.stream()
            .collect(groupingBy(Function.identity(), reducing(0, e -> 1, Integer::sum)));

        return Arrays.stream(LottoResult.values())
            .filter(lottoResult -> lottoResult != LottoResult.NONE)
            .map(lottoResult -> String.format(LOTTO_RESULTS_MESSAGE_FORMAT, lottoResult.makePrintableMessage(),
                resultCounts.getOrDefault(lottoResult, 0)))
            .collect(Collectors.joining(NEW_LINE));
    }
}
