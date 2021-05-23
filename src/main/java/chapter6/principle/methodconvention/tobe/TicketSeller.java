package chapter6.principle.methodconvention.tobe;

import chapter1.domain.TicketOffice;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        // 디미터 법칙 준수
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
}
