package chapter2.domain.condition;

import chapter2.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfindBy(Screening screening);
}
