package chapter1.section3.exercises.ex33;

import std.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedDeque<Item> implements Deque<Item>, Iterable<Item> {

    class LinkedDequeueIterator implements Iterator<Item>{
        Node cur = left;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            Item item = cur.item;
            cur = cur.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedDequeueIterator();
    }

    class Node {
        Item item;
        Node next;
        Node pre;
    }

    private Node left;
    private Node right;
    private int size;


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void pushLeft(Item item) {
        Node newLeft = new Node();
        newLeft.item = item;
        if (size == 0) {
            right = newLeft;
        } else {
            newLeft.next = left;
            left.pre = newLeft;
        }
        left = newLeft;
        size ++;

    }

    @Override
    public void pushRight(Item item) {
        Node newRight = new Node();
        newRight.item = item;
        if(size == 0){
            left = newRight;
        } else {
            newRight.pre = right;
            right.next = newRight;
        }
        right = newRight;
        size ++;

    }

    @Override
    public Item popLeft() {
        if(size == 0){
            throw new NoSuchElementException();
        } else {
            Node newLeft = left.next;
            Item item = left.item;
            if(newLeft != null)
                newLeft.pre = null;
            left = newLeft;
            size --;
            return item;
        }
    }

    @Override
    public Item popRight() {
        if(size == 0){
            throw new NoSuchElementException();
        } else {
            Node newRight = right.pre;
            Item item = right.item;
            if(newRight != null){
                newRight.next = null;
            }
            right = newRight;
            size --;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedDeque<String> deque = new LinkedDeque<>();

        deque.testPushLeft();
        deque.testPushRight();
        deque.testPopLeft();
        deque.testPopRight();
    }

    private void testPushLeft() {
        StdOut.println("Test Push Left");

        LinkedDeque<String> deque = new LinkedDeque<>();
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

        LinkedDeque<String> deque = new LinkedDeque<>();
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

        LinkedDeque<String> deque = new LinkedDeque<>();
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

        LinkedDeque<String> deque = new LinkedDeque<>();
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
}
