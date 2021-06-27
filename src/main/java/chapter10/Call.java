package chapter10;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {

    // 통화 시작 시간, 통화 종료 시간
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}