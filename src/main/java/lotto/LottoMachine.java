package lotto;

import lotto.domain.LottoCount;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResults;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.exception.LottoException;
import lotto.factory.LottoTicketFactory;
import view.InputView;
import view.OutputMessage;
import view.ResultView;

public class LottoMachine {
    public void start() {
        LottoMoney lottoMoney = getLottoMoney();

        LottoCount lottoCount = lottoMoney.calculateLottoCount();
        ResultView.print(String.format(OutputMessage.PRINT_NUMBER_OF_PURCHASED_LOTTO.getMessage(),
            lottoCount.makePrintableMessage()));

        LottoTickets lottoTickets = LottoTicketFactory.createRandomLottoTickets(lottoCount);
        ResultView.print(lottoTickets.makePrintableMessage());
        printWinningStatistics(lottoTickets.calculateResult(getWinnerTicket()));
    }

    private LottoMoney getLottoMoney() {
        ResultView.print(OutputMessage.ASK_PURCHASE_AMOUNT.getMessage());
        try {
            return new LottoMoney(InputView.readLine());
        } catch (LottoException lottoException) {
            ResultView.print(lottoException.getMessage());
            return getLottoMoney();
        }
    }

    private LottoTicket getWinnerTicket() {
        ResultView.print(OutputMessage.PRINT_NEW_LINE.getMessage());
        ResultView.print(OutputMessage.ASK_WINNER_TICKET.getMessage());
        try {
            return new LottoTicket(InputView.readLine());
        } catch (LottoException lottoException) {
            ResultView.print(lottoException.getMessage());
            return getWinnerTicket();
        }
    }

    private void printWinningStatistics(LottoResults lottoResults) {
        ResultView.print(OutputMessage.PRINT_NEW_LINE.getMessage());
        ResultView.print(OutputMessage.PRINT_STATISTICS_INTRO.getMessage());
        ResultView.print(lottoResults.makePrintableMessage());
        ResultView.print(String.format(OutputMessage.PRINT_TOTAL_EARNING_RATE.getMessage(),
            lottoResults.calculateEarningRate().makePrintableMessage()));
    }
}
