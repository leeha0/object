package chapter5.domain.condition;

import chapter5.domain.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        // 순번 조건 판단 로직 변경
        return sequence == screening.getSequence();
    }
}
