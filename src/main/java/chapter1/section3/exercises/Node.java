package chapter1.section3.exercises;

public class Node<Item> {
    Item value;
    Node<Item> next;

    public Node(Item i){
        this.value = i;
    }

    public static <Item> void travrseAndPrint(Node<Item> head){
        while(head !=  null){
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print("null\n");
    }
}
