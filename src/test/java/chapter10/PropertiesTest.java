package chapter10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.Test;

public class PropertiesTest {

    @Test
    void propertiesTest() {
        Properties properties = new Properties();
        properties.setProperty("Bjarne Stroustrup", "C++");
        properties.setProperty("James Gosling", "Java");

        properties.put("Dennis Ritchie", 67);

        // getProperty 메서드는 반환 값의 타입이 String이 아니면 null을 반환한다.
        assertEquals("C", properties.getProperty("Dennis Ritchie"));
    }
}
