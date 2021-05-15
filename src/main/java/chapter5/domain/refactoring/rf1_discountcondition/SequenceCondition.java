package chapter5.domain.refactoring.rf1_discountcondition;

import chapter5.domain.Screening;

public class SequenceCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
