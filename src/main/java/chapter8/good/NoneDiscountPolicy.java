package chapter8.good;

import chapter8.DiscountPolicy;
import chapter8.Money;
import chapter8.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
