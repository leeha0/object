package chapter8.bad;

import java.time.Duration;

import chapter8.DiscountPolicy;
import chapter8.Money;

public class Movie3 {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie3(String title, Duration runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        /*
        // 구체 클래스의 생성자에 전달되는 인자에 대해서 의존성이 생긴다.
        this.discountPolicy = new AmountDiscountPolicy(Money.wons(800),
            new SequenceCondition(1),
            new SequenceCondition(10),
            new PeriodCondition(DayOfWeek.MONDAY,
                LocalTime.of(10, 0), LocalTime.of(11, 59)),
            new PeriodCondition(DayOfWeek.THURSDAY,
                LocalTime.of(10, 0), LocalTime.of(20, 59)));
        */
    }
}
