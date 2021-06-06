package chapter8.bad;

import java.time.Duration;

import chapter8.AmountDiscountPolicy;
import chapter8.DiscountPolicy;
import chapter8.Money;
import chapter8.Screening;

public class Movie2 {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie2(String title, Duration runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        // 구체 클래스를 사용
        // 그체 클래스의 생성자 인자에 대해서도 알아야 한다.
        this.discountPolicy = new AmountDiscountPolicy();
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
