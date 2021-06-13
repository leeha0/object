package chapter9;

import java.time.Duration;

import chapter8.AmountDiscountPolicy;
import chapter8.Money;
import chapter8.Movie;

public class Client {

    public Money getAvatarFee() {
        Movie avatar = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            new AmountDiscountPolicy());
        return avatar.getFee();
    }
}
