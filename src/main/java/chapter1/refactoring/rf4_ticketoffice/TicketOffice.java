package chapter1.refactoring.rf4_ticketoffice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chapter1.domain.Ticket;
import chapter1.refactoring.rf3_bag.Audience;

public class TicketOffice {

    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // Audience 의존성 추가
    // 트레이드오프
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
