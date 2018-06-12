package chapter1.section3.exercises;

import java.util.NoSuchElementException;

public class Ex19 {
    class Node<Item> {
        Item value;
        Node next;
    }

    public <Item> void deleteLast(Node<Item> first) {
        if(first == null || first.next == null){
            throw new NoSuchElementException();
        }
        Node last = first;
        Node cur = first.next;
        while(cur.next != null){
            last = cur;
            cur = cur.next;
        }
        last.next = null;
    }
}
