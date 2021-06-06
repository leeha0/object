package chapter8.bad;

import java.time.Duration;

import chapter8.Money;
import chapter8.PercentDiscountPolicy;
import chapter8.Screening;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private PercentDiscountPolicy percentDiscountPolicy;

    public Movie(String title, Duration runningTime, Money fee, PercentDiscountPolicy percentDiscountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.percentDiscountPolicy = percentDiscountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(percentDiscountPolicy.calculateDiscountAmount(screening));
    }
}
