package chapter10.refactoring.rf1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chapter10.Call;
import chapter10.Money;

public class Phone {

    private Money amount;
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
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
