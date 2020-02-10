package chapter4.data.agent;

import chapter2.domain.Money;
import chapter4.data.domain.*;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        // 할인 조건 비교
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
                        && condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
                        && condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }

        Money fee = screening.calculateFee(audienceCount);
//        if (discountable) {
//            // 할인 금액
//            Money discountAmount = Money.ZERO;
//            switch (movie.getMovieType()) {
//                case AMOUNT_DISCOUNT:
//                    discountAmount = movie.getDiscountAmount();
//                    break;
//                case PERCENT_DISCOUNT:
//                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
//                    break;
//                case NONE_DISCOUNT:
//                    discountAmount = Money.ZERO;
//                    break;
//            }
//
//            fee = movie.getFee().minus(discountAmount).times(audienceCount);
//        } else {
//            fee = movie.getFee();
//        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
