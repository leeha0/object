package chapter1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    // 금액
    private Long amount;
    // 티켓 목록
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // Audience 의존성 추가
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.by(getTicket()));
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
