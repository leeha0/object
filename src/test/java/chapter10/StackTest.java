package chapter10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    void stackTest() {
        Stack<String> stack = new Stack<>();
        stack.push("1st");
        stack.push("2nd");
        stack.push("3rd");

        stack.add(0, "4th");

        assertEquals("4th", stack.pop());
    }
}
