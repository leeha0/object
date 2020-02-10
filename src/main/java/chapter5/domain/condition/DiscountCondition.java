package chapter5.domain.condition;

import chapter5.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
