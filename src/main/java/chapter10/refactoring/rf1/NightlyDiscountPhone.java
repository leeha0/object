package chapter10.refactoring.rf1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chapter10.Call;
import chapter10.Money;

public class NightlyDiscountPhone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            // 변하지 않는 것으로부터 변하는 것을 분리
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    private Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        } else {
            return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
    }
}
