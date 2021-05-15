package chapter5.domain.refactoring.rf3_movie;

import java.time.Duration;

import chapter5.domain.Money;

public class NonDiscountMovie extends Movie {

    public NonDiscountMovie(String title, Duration runningTime, Money fee,
        DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
