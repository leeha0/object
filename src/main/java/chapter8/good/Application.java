package chapter8.good;

import java.time.Duration;

import chapter8.AmountDiscountPolicy;
import chapter8.Money;
import chapter8.PercentDiscountPolicy;

public class Application {

    public static void main(String[] args) {
        Movie avatar = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            new OverlappedDiscountPolicy(
                new AmountDiscountPolicy(),
                new PercentDiscountPolicy()));
    }
}
