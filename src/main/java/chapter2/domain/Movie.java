package chapter2.domain;

import java.time.Duration;

import chapter2.domain.policy.DiscountPolicy;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    // 생성자를 통해 파라미터 강제
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
        // 할인 정책이 없는 경우 일관성 있던 협력 방식이 무너진다 (예외 상황 발생)
        // NonDiscountPolicy 클래스 추가
        // if (discountPolicy == null) {
        //     return fee;
        // }

        // 어떤 할인 정책을 사용할 것인지 결정하는 코드는 어디에도 존재하지 않는다
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
