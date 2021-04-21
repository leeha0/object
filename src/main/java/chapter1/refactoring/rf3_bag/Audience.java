package chapter1.refactoring.rf3_bag;

import chapter1.domain.Ticket;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
