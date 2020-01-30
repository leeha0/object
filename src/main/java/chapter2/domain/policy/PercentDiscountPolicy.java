package chapter2.domain.policy;

import chapter2.domain.Money;
import chapter2.domain.Screening;
import chapter2.domain.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
