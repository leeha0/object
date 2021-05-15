package chapter2.tradeoff.policy;

import chapter2.domain.Money;
import chapter2.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
