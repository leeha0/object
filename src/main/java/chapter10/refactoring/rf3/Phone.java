package chapter10.refactoring.rf3;

import java.util.ArrayList;
import java.util.List;

import chapter10.Call;
import chapter10.Money;

public abstract class Phone {

    // 세금 정책 추가
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        // 세금 부여
        return result.plus(result.times(taxRate));
    }

    protected abstract Money calculateCallFee(Call call);
}