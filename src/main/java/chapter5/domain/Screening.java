package chapter5.domain;

import chapter2.domain.Customer;
import chapter2.domain.Money;
import chapter2.domain.Reservation;
import chapter5.domain.movie.Movie;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public void setWhenScreened(LocalDateTime whenScreened) {
        this.whenScreened = whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    // 예매하라: 예약 객체 생성
    public Reservation reserve(Customer customer, int audienceCount) {
        return null;
    }

    // 가격을 계산하라: 가격 전문가에게 메시지 전달
    public Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
