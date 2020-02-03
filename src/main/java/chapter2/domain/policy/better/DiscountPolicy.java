package chapter2.domain.policy.better;

import chapter2.domain.Money;
import chapter2.domain.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
