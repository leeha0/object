package chapter9;

import java.time.Duration;

import chapter8.AmountDiscountPolicy;
import chapter8.Money;
import chapter8.PercentDiscountPolicy;

public class ServiceLocatorClient {

    public static void main(String[] args) {
        ServiceLocator.provide(new AmountDiscountPolicy());
        Movie avatar1 = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000));

        ServiceLocator.provide(new PercentDiscountPolicy());
        Movie avatar2 = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000));
    }
}
