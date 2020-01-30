package chapter2.domain.condition;

import chapter2.domain.Screening;

public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfindBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
