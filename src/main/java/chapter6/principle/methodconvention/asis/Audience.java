package chapter6.principle.methodconvention.asis;

import chapter1.domain.Ticket;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public long setTicket(Ticket ticket) {
        return bag.setTicket(ticket);
    }
}
