package chapter2.domain.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chapter2.domain.Money;
import chapter2.domain.Screening;
import chapter2.domain.condition.DiscountCondition;

public abstract class DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    // 생성자를 통해 파라미터 강제
    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    // 공통 로직 구현
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    // 템플릿 메서드 패턴
    abstract protected Money getDiscountAmount(Screening screening);
}
