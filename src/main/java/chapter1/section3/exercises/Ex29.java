package chapter1.section3.exercises;

import java.util.NoSuchElementException;

public class Ex29<Item> {
    public static class Queue<Item> {
        class Node {
            Item v;
            Node next;
        }

        Node last;

        public void enqueue(Item item) {
            Node newLast = new Node();
            newLast.v = item;
            if(last != null) {
                Node first = last.next;
                newLast.next = first;
                last.next = newLast;
                last = newLast;
            } else {
                last = newLast;
                newLast.next = last;
            }
        }

        public Item dequeue(){
            if(last == null){
                throw new NoSuchElementException("queue underflow");
            } else {
                //only one node
                if(last.next == last){
                    Item r = last.v;
                    last = null;
                    return r;
                } else {
                    Node first = last.next;
                    Node newFirst = first.next;
                    last.next = newFirst;
                    return first.v;
                }
            }
        }

        public boolean isEmpty(){
            return last == null;
        }
    }
}
