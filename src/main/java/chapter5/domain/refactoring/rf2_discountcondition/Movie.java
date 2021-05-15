package chapter5.domain.refactoring.rf2_discountcondition;

import java.util.List;

import chapter5.domain.Money;
import chapter5.domain.Screening;

public class Movie {

    private Money fee;
    private List<DiscountCondition> discountConditions;

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

    private Money calculateDiscountAmount() {
        return null;
    }
}