package chapter10.nightly;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chapter10.Call;
import chapter10.Money;

public class NightlyDiscountPhone {

    private static final int LATE_NIGHT_HOUR = 22;

    // 10시 이후 통화 요금, 10시 이전 통화 요금, 단위 시간, 통화 목록
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result;
    }
}
