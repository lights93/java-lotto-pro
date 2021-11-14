package lotto.factory;

import static lotto.domain.Ball.*;
import static lotto.domain.Ticket.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Count;
import lotto.domain.Ticket;
import lotto.domain.Tickets;

public class TicketFactory {
    public static Tickets createRandomTickets(Count count) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; count.isBiggerThan(i); i++) {
            tickets.add(createRandomTicket());
        }

        return new Tickets(tickets);
    }

    private static Ticket createRandomTicket() {
        List<Integer> possibleNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(possibleNumbers);

        return new Ticket(possibleNumbers.stream()
            .limit(SIZE)
            .collect(Collectors.toList()));
    }
}
