package chapter6.principle.telldontask.asis;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        // 디미터 법칙 준수
        ticketSeller.setTicket(audience);
    }
}
