package chapter5.domain.refactoring.rf6_reservationagent;

import java.time.DayOfWeek;
import java.time.LocalTime;

import chapter5.domain.DiscountConditionType;

public class DiscountCondition {

    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek)
            && startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
            && endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }
}
