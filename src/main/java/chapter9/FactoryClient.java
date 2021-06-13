package chapter9;

import chapter8.Money;
import chapter8.Movie;

public class FactoryClient {

    private Factory factory;

    public FactoryClient(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }
}
