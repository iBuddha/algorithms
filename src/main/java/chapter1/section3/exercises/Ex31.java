package chapter1.section3.exercises;

public class Ex31 {
    static class DoubleNode<Item> {
        Item value;
        DoubleNode<Item> pre;
        DoubleNode<Item> next;

        public DoubleNode(Item v) {
            this.value = v;
        }
    }

    static class DoublyLinkedList<Item> {
        DoubleNode<Item> head;
        DoubleNode<Item> last;
    }

    public static <Item> void insertBeforeHead(DoublyLinkedList<Item> list, Item value) {
        DoubleNode<Item> newHead = new DoubleNode<>(value);
        newHead.pre = null;
        newHead.next = list.head;
        list.head.pre = newHead;
        list.head = newHead;
    }
    //太简单就不全实现了

}
