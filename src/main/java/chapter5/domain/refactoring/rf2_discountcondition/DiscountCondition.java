package chapter5.domain.refactoring.rf2_discountcondition;

import chapter5.domain.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
