package chapter1.section3.exercises.ex33;


import std.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * 基于resizing array。
 *
 * @param <Item>
 */
public class ArrayDeque<Item> implements Deque<Item>, Iterable<Item> {
    private Item[] a = (Item[]) new Object[2];
    private int n;
    private int left = 0;//left在数组的低位，表示最左边的元素，如果非空
    private int right = 1; //right在数组的高位，表右最右边的元素，如果非空

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private void resize(int capacity) {
        System.out.println("resize to " + capacity);
        Item[] newArray = (Item[]) new Object[capacity];
        int size = n;
        for (int j = 0; j < n; j++) {
            newArray[j] = a[(left + j) % a.length];
        }
        a = newArray;
        if (size == 0) {
            left = -1;
            right = -1;
        } else {
            left = 0;
            right = n - 1;
        }
    }

    @Override
    public void pushLeft(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        if (left == 0)
            left = a.length - 1;
        else
            left = left - 1;
        a[left] = item;
        n++;
    }

    @Override
    public void pushRight(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        if (right == a.length - 1)
            right = 0;
        else
            right = right + 1;
        a[right] = item;
        n++;

    }

    @Override
    public Item popLeft() {
        if (n == 0)
            throw new NoSuchElementException();
        Item result = a[left];
        a[left] = null;
        n--;
        if (left == a.length - 1)
            left = 0;
        else
            left = left + 1;
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return result;
    }

    @Override
    public Item popRight() {
        if (n == 0)
            throw new NoSuchElementException();
        Item result = a[right];
        a[right] = null;
        n--;
        if (right == 0)
            right = a.length - 1;
        else
            right = right - 1;
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return result;
    }

    class ArrayDequeIterator implements Iterator<Item> {
        int i = n;//待访问的元素数量

        @Override
        public boolean hasNext() {
            if (n == 0)
                return false;
            else {
                return i > 0 ;
            }
        }

        @Override
        public Item next() {
            if (n == 0)
                throw new NoSuchElementException();
            Item result = a[(left + n - i) % a.length];
            i--;
            return result;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayDequeIterator();
    }

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.testPushLeft();
        deque.testPushRight();
        deque.testPopLeft();
        deque.testPopRight();
        deque.testResize();
    }

    private void testPushLeft() {
        StdOut.println("Test Push Left");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");

        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: c b a");
    }

    private void testPushRight() {
        StdOut.println("\nTest Push Right");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: a b c");
    }

    private void testPopLeft() {
        StdOut.println("\nTest Pop Left");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popLeft();
        deque.popLeft();

        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: c");
    }

    private void testPopRight() {
        StdOut.println("\nTest Pop Right");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushRight("c");

        deque.popRight();
        deque.popRight();

        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }

        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: a");
    }

    private void testResize() {
        ArrayDeque<String> deque = new ArrayDeque<>();
        for(int i = 0; i < 12; i++) {
            deque.pushLeft("a");
            deque.pushRight("b");
        }
        for(int i  = 0; i < 12; i++){
            deque.popRight();
            deque.popLeft();
        }
        deque.pushLeft("a");
        deque.pushLeft("b");
        deque.pushLeft("c");
        deque.pushLeft("d");
        deque.pushLeft("e");
        StringJoiner dequeItems = new StringJoiner(" ");
        for (String item : deque) {
            dequeItems.add(item);
        }
        StdOut.println("Deque items: " + dequeItems.toString());
        StdOut.println("Expected: e d c b a");
    }
}
