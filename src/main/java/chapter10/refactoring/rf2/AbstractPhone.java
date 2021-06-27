package chapter10.refactoring.rf2;

import java.util.ArrayList;
import java.util.List;

import chapter10.Call;
import chapter10.Money;

public abstract class AbstractPhone {

    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}