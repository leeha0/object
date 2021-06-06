package chapter8.good;

import java.time.Duration;

import chapter8.AmountDiscountPolicy;
import chapter8.DiscountPolicy;
import chapter8.Money;
import chapter8.Screening;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee) {
        // 자주 협력하는 구현체
        // 생성자 체이닝
        this(title, runningTime, fee, new AmountDiscountPolicy());
    }

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        // 가끔 협력하는 구현체
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}