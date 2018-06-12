package chapter1.section3.exercises;

import main.java.chapter1.section3.exercises.Ex01.FixedCapacityStackOfString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ex1Test {

    @Test
    void testIsFull() {
        FixedCapacityStackOfString stack = new FixedCapacityStackOfString(3);
        Assertions.assertEquals(false, stack.isFull());
        stack.push("a");
        stack.push("a");
        stack.push("a");
        Assertions.assertEquals(true, stack.isFull());
    }
}
