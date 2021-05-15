package chapter5.domain.refactoring.rf3_movie;

import chapter5.domain.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
