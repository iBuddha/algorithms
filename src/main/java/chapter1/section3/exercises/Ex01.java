package main.java.chapter1.section3.exercises;

import java.util.NoSuchElementException;

/**
 * add a method is full() to FixedCapacityStackOfString
 */
public class Ex01 {
    public static class FixedCapacityStackOfString {
        private final String[] a;
        private int n = 0;// next position to store new item

        public FixedCapacityStackOfString(int capacity){
            a = new String[capacity];
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public boolean isFull(){
            return n == a.length;
        }

        public void push(String s) {
            if(n == a.length)
                throw new RuntimeException("stack is full");
            else
                a[n++] = s;
        }

        public String pop(){
            if(n == 0)
                throw new NoSuchElementException();
            String r = a[--n];
            a[n] = null;
            return r;
        }

    }
}
