package chapter10;

import java.util.Arrays;

public class InstrumentedHashSetApplication {

    public static void main(String[] args) {
        InstrumentedHashSet<String> languages = new InstrumentedHashSet<>();
        languages.addAll(Arrays.asList("Java", "Ruby", "Scala"));

        System.out.println(languages.size()); // 3
        System.out.println(languages.getAddCount()); // 6
    }
}
