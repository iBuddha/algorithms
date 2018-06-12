package chapter1.section3.content;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int N = 0; // the next item's index for pushing

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 需要处理好进行resize的条件
     */
    public Item pop() {
        Item e = items[--N];
        items[N] = null; //remove for gc
        if(N > 0 && N == items.length / 4)
            resize(items.length / 2);
        return e;
    }

    public void push(Item item) {
        if(N == items.length)
            resize(items.length * 2);
        items[N++] = item;
    }

    public void resize(int size) {
        Item[] items = (Item[]) new Object[size];
        for (int i = 0; i < N; i++)
            items[i] = this.items[i];
        this.items = items;
    }

    private class StackIterator implements Iterator <Item>{
        int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }


    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
}
