package chapter5.domain.refactoring.rf6_reservationagent;

import chapter5.domain.Customer;
import chapter5.domain.Money;
import chapter5.domain.Movie;
import chapter5.domain.Reservation;
import chapter5.domain.Screening;

public class ReservationAgency {

    private DiscountCondition discountCondition;

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);

        return createReservation(screening, customer, audienceCount, fee);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream()
            .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie().getFee()
                .minus(calculateDiscountedFee(screening.getMovie()))
                .times(audienceCount);
        }

        return screening.getMovie().getFee();
    }

    private Money calculateDiscountedFee(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountedFee(movie);
            case NONE_DISCOUNT:
                return calculateNonDiscountedFee(movie);
        }

        throw new IllegalArgumentException();
    }

    private Money calculateNonDiscountedFee(Movie movie) {
        return movie.getFee();
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
