package chapter2.domain;

import java.time.LocalDateTime;

public class Screening {
    // 인스턴스 변수의 가시성은 private
    // 영화
    private Movie movie;
    // 순번
    private int sequence;
    // 상영 시작 시간
    private LocalDateTime whenScreened;

    // 메서드의 가시성은 public
    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
