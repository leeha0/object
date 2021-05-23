package chapter5.domain.refactoring.rf6_reservationagent;

import java.time.LocalDateTime;

import chapter5.domain.Customer;
import chapter5.domain.Money;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getSequence() {
        return sequence;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
