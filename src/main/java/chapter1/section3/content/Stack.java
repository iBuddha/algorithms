package chapter1.section3.content;

public class Stack<Item> {
    private class Node {
        Item value;
        Node next;
    }

    private Node first;

    public Item pop() {
        if(first == null)
            return null;
        Node oldFirst = first;
        first = first.next;
        return oldFirst.value;
    }

    public void push(Item e){
        Node newFirst = new Node();
        newFirst.value = e;
        newFirst.next = first;
        first = newFirst;
    }

    public boolean isEmpty(){
        return first == null;
    }


    public Item peek() {
            if(first == null)
                return null;
            else
                return first.value;
    }
}
