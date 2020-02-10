package chapter5.domain.movie;

import chapter2.domain.Money;
import chapter5.domain.Screening;
import chapter5.domain.condition.DiscountCondition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private Money discountAmount;

    // 초기 설계
    //    private List<DiscountCondition> discountConditions;

    // 타입 분리
    //    private List<PeriodCondition> periodConditions;
    //    private List<SequenceCondition> sequenceConditions;

    // 다형성을 통한 분리
    private List<DiscountCondition> discountConditions;

    // 초기 설계
    //    private MovieType movieType;
    //    private Money discountAmount;
    //    private Noney discountPercent;


    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    protected Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    abstract protected Money calculateDiscountAmount();

    // 초기 설계
    //    private Money calculateDiscountAmount() {
    //        switch (movieType) {
    //            case AMOUNT_DISCOUNT:
    //                return calculateAmountDiscountAmount();
    //            case PERCENT_DISCOUNT:
    //                return calculatePercentDiscountAmount();
    //            case NONE_DISCOUNT:
    //                return calculateNoneDiscountAmount();
    //        }
    //
    //        throw new IllegalArgumentException();
    //    }
    //
    //    private Money calculateNoneDiscountAmount() {
    //        return Money.ZERO;
    //    }
    //
    //    private Money calculatePercentDiscountAmount() {
    //        return fee.times(discountPercent);
    //    }
    //
    //    private Money calculateAmountDiscountAmount() {
    //        return discountAmount;
    //    }

    private boolean isDiscountable(Screening screening) {
        // 초기 설계
        //        return discountConditions.streams().anyMatch(condition -> condition.isSatisfiedBy(screening));

        // 타입 분리
        //        return checkPeriodConditions(screening) || checkSequenceConditions(screening);

        // 다형성을 통한 분리
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    //    private boolean checkPeriodConditions(Screening screening) {
    //        return periodConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    //    }
    //
    //    private boolean checkSequenceConditions(Screening screening) {
    //        return sequenceConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    //    }
}
