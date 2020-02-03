package chapter2.domain.policy.better;

import chapter2.domain.Money;
import chapter2.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
