package chapter6.principle.demeter.tobe;

import chapter4.domain.Customer;
import chapter4.domain.Money;
import chapter4.domain.refactoring.Reservation;
import chapter4.domain.refactoring.Screening;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        // 메서드의 인자로 전달된 클래스
        // 메서드의 매개변수
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
