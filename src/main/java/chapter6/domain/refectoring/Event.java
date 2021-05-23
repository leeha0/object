package chapter6.domain.refectoring;

import java.time.Duration;
import java.time.LocalDateTime;

import chapter6.domain.RecurringSchedule;

public class Event {

    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    // 쿼리
    public boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek()
            || !from.toLocalTime().equals(schedule.getFrom())
            || !duration.equals(schedule.getDuration())) {
            return false;
        }

        return true;
    }

    // 명령
    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule))
            , schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long dayDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
