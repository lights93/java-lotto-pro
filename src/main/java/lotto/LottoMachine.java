package lotto;

import lotto.domain.Ball;
import lotto.domain.Count;
import lotto.domain.Money;
import lotto.domain.Ranks;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.domain.WinnerBall;
import lotto.exception.LottoException;
import lotto.factory.TicketFactory;
import view.InputView;
import view.ResultView;

public class LottoMachine {
    public void start() {
        Money money = getMoney();

        Count totalCount = money.calculateCount();
        ResultView.printNumberOfPurchasedLotto(totalCount.getCount());

        Count manualCount = getManualCount();

        Tickets tickets = TicketFactory.createRandomTickets(totalCount);
        ResultView.printTickets(tickets);

        Ticket winnerTicket = getTicket();
        WinnerBall winnerBall = getWinnerTicket(winnerTicket);

        Ranks ranks = winnerBall.calculateRank(tickets);
        ResultView.printWinningStatistics(ranks.makeStatistics());
    }

    private Money getMoney() {
        ResultView.printAskPurchaseAmount();
        try {
            return InputView.readMoney();
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getMoney();
        }
    }

    private Count getManualCount() {
        ResultView.printAskManualCount();
        try {
            return InputView.readCount();
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getManualCount();
        }
    }

    private Ticket getTicket() {
        ResultView.printAskWinnerTicket();
        try {
            return InputView.readTicket();
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getTicket();
        }
    }

    private WinnerBall getWinnerTicket(Ticket ticket) {
        ResultView.printAskBonusNumber();

        try {
            Ball ball = InputView.readBall();
            return new WinnerBall(ticket, ball);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerTicket(ticket);
        }

    }
}
