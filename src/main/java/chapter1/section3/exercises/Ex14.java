package chapter1.section3.exercises;

import java.util.NoSuchElementException;

public class Ex14 {
    public static class ResizingArrayQueueOfString {
        private String[] a;
        private int head;
        private int tail;
        private int size;

        public ResizingArrayQueueOfString(int capacity) {
            a = new String[capacity];
            head = 0; //position to dequeue
            tail = 0; //position to enqueue
            size = 0;
        }

        private boolean isFull() {
            return size == a.length;
        }

        public int size() {
            return size;
        }

        private void resize(int capacity) {
            String[] newArray = new String[capacity];
            for(int j =0; j < size; j++){
                newArray[j] = a[(head + j) % a.length];
            }
            head = 0;
            tail = size;
            a = newArray;
        }

        public void enqueue(String s) {
            if (isFull()) {
                resize(s.length() * 2);
                enqueue(s);
                return;
            } else if (tail == a.length) {
                tail = 0;
            }
            a[tail++] = s;
            size++;
        }

        public String dequeue() {
            if(size == 0){
                throw new NoSuchElementException();
            } else {
                String result = a[head];
                a[head] = null;
                head++;
                if(head == a.length)
                    head = 0;
                size --;
                if(size > 0 && size == a.length / 4){
                    resize(a.length /2);
                }
                return result;
            }
        }
    }
}
