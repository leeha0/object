package chapter10.taxrate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chapter10.Call;
import chapter10.Money;

public class Phone {

    // 단위 요금, 단위 시간, 통화 목록
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    // 세금 정책 추가
    private double taxRate;

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        // 세금 부과
        return result.plus(result.times(taxRate));
    }
}
