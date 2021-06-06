package chapter8.good;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chapter8.DiscountPolicy;
import chapter8.Money;
import chapter8.Screening;

public class OverlappedDiscountPolicy extends DiscountPolicy {

    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
        this.discountPolicies = Arrays.asList(discountPolicies);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return null;
    }
}
