package chapter8.bad;

import java.time.Duration;

import chapter8.DiscountPolicy;
import chapter8.Money;
import chapter8.Screening;

public class Movie4 {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie4(String title, Duration runningTime, Money fee) {
        this(title, runningTime, fee, null);
    }

    public Movie4(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        // 협력의 예외 발생
        if (discountPolicy == null) {
            return fee;
        }

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
