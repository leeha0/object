package chapter1.domain;

public class TicketSeller {
    // 매표소
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

//    public TicketOffice getTicketOffice() {
//        return ticketOffice;
//    }

    // Theater, TicketOffice 간의 의존성 제거 및 캡슐화
    // TicketSeller 자율적 존재
    public void sellTo(Audience audience) {
//        if (audience.getBag().hasInvitation()) {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().setTicket(ticket);
//        } else {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketOffice.plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }

        // Audience, Bag 간의 의존성 제거 및 캡슣화
        // Bag 자율적 존재
//        ticketOffice.plusAmount(audience.by(ticketOffice.getTicket()));

        // TicketOffice 자율적인 존재
        ticketOffice.sellTicketTo(audience);
    }
}
