package chapter6.principle.methodconvention.asis;

import chapter1.domain.TicketOffice;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void setTicket(Audience audience) {
        // 디미터 법칙 준수
        ticketOffice.plusAmount(audience.setTicket(ticketOffice.getTicket()));
    }
}
