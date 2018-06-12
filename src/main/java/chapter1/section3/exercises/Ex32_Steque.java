package chapter1.section3.exercises;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Steque. A stack-ended queue or steque is a data type that supports push, pop, and enqueue.
 * Articulate an API for this ADT. Develop a linked-list-based implementation.
 * stack-ended queue是说queue的一端可以当成stack来用
 */
public class Ex32_Steque {

    static class Steque<Item> implements Iterable<Item> {
        /**
         * 若是不基于双向链表来实现，那么至少有一个操作的复杂度是O(n)
         */
        class Node {
            Item value;
            Node pre;
            Node next;

            public Node(Item v) {
                this.value = v;
            }
        }

        //head.next.next ...  last
        Node head;
        Node last;
        int size;

        public void push(Item item) {
            Node newHead = new Node(item);
            newHead.next = head;
            if (head != null) {
                head.pre = newHead;
            }
            if (last == null) {
                last = newHead;
            }
            this.head = newHead;
            size++;
        }

        public Item pop() {
            if (size == 0)
                throw new NoSuchElementException();
            else {
                Node newHead = head.next;
                //TODO: 一开始没加下边这个判断，所以会抛NullPointerException
                if (newHead != null)
                    newHead.pre = null;
                Item r = head.value;
                this.head = newHead;
                size--;
                return r;
            }
        }

        public void enqueue(Item item) {
            Node newLast = new Node(item);
            newLast.pre = last;
            if (head == null) {
                head = newLast;
            } else {
                last.next = newLast;
            }
            this.last = newLast;
            size++;
        }

        class StequeIterator implements Iterator<Item> {
            Node cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Item next() {
                Item r = cur.value;
                cur = cur.next;
                return r;
            }
        }

        @Override
        public Iterator<Item> iterator() {
            return new StequeIterator();
        }
    }

    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();
        steque.push("a");
        steque.push("b");
        steque.push("c");
        String c = steque.pop();
        System.out.println("c: " + c);
        steque.enqueue("d");
        System.out.println("b: " + steque.pop());
        System.out.println("a: " + steque.pop());
        System.out.println("d: " + steque.pop());

    }
}
