package chapter5.domain.refactoring.rf3_movie;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import chapter5.domain.Money;
import chapter5.domain.Screening;

public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee,
        DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    protected Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
            .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();
}
