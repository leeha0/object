package chapter8;

public class AmountDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }
}
