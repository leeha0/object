package chapter10.inheritance;

import java.time.Duration;

import chapter10.Call;
import chapter10.Money;
import chapter10.Phone;

public class NightlyDiscountPhone extends Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        super(regularAmount, seconds);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        // 부모 클래스의 calculateFee 호출
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;
        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(getAmount().minus(nightlyAmount)
                    .times(call.getDuration().getSeconds() / getSeconds().getSeconds()));
            }
        }

        // 세금을 부과하는 요구사항에서 왜 심야 요금을 빼는가?
        return result.minus(nightlyFee);
    }
}