package chapter1.section3.exercises;

import main.java.chapter1.section3.exercises.Ex01.FixedCapacityStackOfString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

public class Ex29Test {

    @Test
    void test() {
        Ex29.Queue<String> queue = new Ex29.Queue<>();
        Assertions.assertEquals(true, queue.isEmpty());
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        String a = queue.dequeue();
        String b = queue.dequeue();
        String c = queue.dequeue();
        Assertions.assertEquals(true, queue.isEmpty());
        Assertions.assertEquals(a, "a");
        Assertions.assertEquals(a, "a");
        Assertions.assertEquals(a, "a");
    }
}
