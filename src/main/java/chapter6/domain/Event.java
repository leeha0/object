package chapter6.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {

    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    public boolean isSatisfied(RecurringSchedule schedule) {
        // 명령과 쿼리 두 가지 역할을 동시에 수행
        if (from.getDayOfWeek() != schedule.getDayOfWeek()
            || !from.toLocalTime().equals(schedule.getFrom())
            || !duration.equals(schedule.getDuration())) {
            // 부수효과를 가지는 명령
            reschedule(schedule);
            return false;
        }

        return true;
    }

    private void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule))
            , schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long dayDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
