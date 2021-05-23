package chapter6.domain.refectoring;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import chapter6.domain.RecurringSchedule;

class EventTest {

    @Test
    void isSatisfiedTest() {
        RecurringSchedule schedule = new RecurringSchedule("회의"
            , DayOfWeek.WEDNESDAY
            , LocalTime.of(10, 30)
            , Duration.ofMinutes(30));
        Event thursdayMeeting = new Event("회의"
            , LocalDateTime.of(2019, 5, 9, 10, 30)
            , Duration.ofMinutes(30));

        assertFalse(thursdayMeeting.isSatisfied(schedule));
        assertFalse(thursdayMeeting.isSatisfied(schedule));
    }

    @Test
    void isSatisfiedTrueTest() {
        RecurringSchedule schedule = new RecurringSchedule("회의"
            , DayOfWeek.WEDNESDAY
            , LocalTime.of(10, 30)
            , Duration.ofMinutes(30));

        Event meeting = new Event("회의"
            , LocalDateTime.of(2019, 5, 8, 10, 30)
            , Duration.ofMinutes(30));

        assertTrue(meeting.isSatisfied(schedule));
    }

    @Test
    void isSatisfiedFalseTest() {
        RecurringSchedule schedule = new RecurringSchedule("회의"
            , DayOfWeek.WEDNESDAY
            , LocalTime.of(10, 30)
            , Duration.ofMinutes(30));

        Event meeting = new Event("회의"
            , LocalDateTime.of(2019, 5, 9, 10, 30)
            , Duration.ofMinutes(30));

        assertFalse(meeting.isSatisfied(schedule));
    }
}