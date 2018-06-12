package chapter1.section3.exercises;

public class Ex30 {

    public static <Item> Node<Item> reverse(Node<Item> head){
        if(head == null || head.next == null){
            return head;
        }

        Node<Item> reversed = null;
        Node<Item> cur = head;
        while(cur != null){
            Node<Item> next = cur.next;
            cur.next = reversed;
            reversed = cur;
            cur = next;
        }
        return reversed;
    }

    public static <Item> Node<Item> reverseRecursively(Node<Item> head){
        if(head == null || head.next == null){
            return head;
        } else {
            Node<Item> next = head.next;
            //TODO:下一步第一遍写的时候忘了，想一下为什么这样会造成结果是一个循环链表
            head.next = null;
            Node<Item> reversed = reverseRecursively(next);
            next.next = head;
            return reversed;
        }
    }

    public static void main(String[] args) {
        Node<String> a = new Node("a");
        Node<String> b = new Node("b");
        Node<String> c = new Node("c");
        a.next = b;
        b.next = c;
        Node reversed = reverse(a);
        Node.travrseAndPrint(reversed);
        reversed = reverseRecursively(reversed);
        Node.travrseAndPrint(reversed);

    }

}
