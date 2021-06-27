package chapter8;

public class PercentDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }
}
