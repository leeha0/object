package chapter10.inheritance;

import java.time.Duration;

import chapter10.Call;
import chapter10.Money;
import chapter10.taxrate.Phone;

public class NightlyDiscountPhone2 extends Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone2(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        super(regularAmount, seconds, taxRate);
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

        // 부모 클래스에 세금 부과 정책이 추가되어 자식 클래스도 세금을 부과해야 한다.
        return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
    }
}