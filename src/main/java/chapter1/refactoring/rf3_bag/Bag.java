package chapter1.refactoring.rf3_bag;

import chapter1.domain.Invitation;
import chapter1.domain.Ticket;

public class Bag {

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    // 현금만 갖는 고객
    public Bag(Long amount) {
        this.amount = amount;
    }

    // 초대장과 현금을 갖는 고객
    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
