package chapter1.domain;

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

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
