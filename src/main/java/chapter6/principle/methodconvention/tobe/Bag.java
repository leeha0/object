package chapter6.principle.methodconvention.tobe;

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
            hold(ticket);
            return 0L;
        } else {
            hold(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
