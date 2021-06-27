package chapter10.refactoring.rf2;

import java.time.Duration;

import chapter10.Call;
import chapter10.Money;

public class Phone extends AbstractPhone {

    private Money amount;
    private Duration seconds;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
