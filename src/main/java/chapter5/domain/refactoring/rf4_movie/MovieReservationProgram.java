package chapter5.domain.refactoring.rf4_movie;

import java.time.Duration;

import chapter5.domain.Money;

public class MovieReservationProgram {

    public static void main(String[] args) {
        Movie movie = new Movie(
            "타이타닉"
            , Duration.ofMinutes(120)
            , Money.wons(10000)
            , new AmountDiscountPolicy());
        movie.changeDiscountPolicy(new PercentDiscountPolicy());
    }
}
