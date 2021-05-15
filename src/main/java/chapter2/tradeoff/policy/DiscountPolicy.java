package chapter2.tradeoff.policy;

import chapter2.domain.Money;
import chapter2.domain.Screening;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
