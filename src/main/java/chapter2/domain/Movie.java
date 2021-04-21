package chapter2.domain;

import chapter2.domain.policy.DiscountPolicy;

import java.time.Duration;

public class Movie {
    // 제목
    private String title;
    // 상영시간
    private Duration runningTime;
    // 기본요금
    private Money fee;
    // 할인 정책
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
