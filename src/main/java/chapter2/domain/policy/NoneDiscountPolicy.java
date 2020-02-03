package chapter2.domain.policy;

import chapter2.domain.Money;
import chapter2.domain.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
