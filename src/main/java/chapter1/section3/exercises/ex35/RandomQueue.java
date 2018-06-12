package chapter1.section3.exercises.ex35;

import java.util.Iterator;
import java.util.Random;

public class RandomQueue<Item> implements Iterable<Item> {
    private static Random rand = new Random();

    private Item[] a = (Item[]) new Object[2];

    int N; //size

    public boolean isEmpty(){return N == 0;}

    public void enqueue(Item item) {
        if(N == a.length)
            resize(a.length * 2);
        a[N++] = item;
    }

    public Item dequque(){
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        int index = rand.nextInt(N);
        Item result = a[index];
        a[index] = a[N-1];
        a[N-1] = null;
        if(N > 0 && N == a.length / 4)
            resize(a.length /2);
        N--;
        return result;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return a[rand.nextInt(N)];
    }

    private void resize(int capacity){
        Item[] newArray = (Item[]) new Object[capacity];
        for(int i = 0; i < N; i++)
            newArray[i] = a[i];
        a = newArray;
    }




    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
