package chapter1.domain;

public class Audience {
    // 가방
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

//    public Bag getBag() {
//        return bag;
//    }

    public Long by(Ticket ticket) {
//        if (bag.hasInvitation()) {
//            bag.setTicket(ticket);
//            return 0L;
//        } else {
//            bag.setTicket(ticket);
//            bag.minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }
        return bag.hold(ticket);
    }
}
