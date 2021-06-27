package chapter10.refactoring.rf3;

import java.time.Duration;

import chapter10.Call;
import chapter10.Money;

public class RegularPhone extends Phone {

    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds, double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
