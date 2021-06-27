package chapter10.taxrate;

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

    // 세금 정책 추가
    private double taxRate;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
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

        // 세금 부과
        return result.minus(result.times(taxRate));
    }
}
