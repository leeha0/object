package chapter2.domain.condition;

import chapter2.domain.Screening;

public class SequenceCondition implements DiscountCondition {

    // 순번
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
