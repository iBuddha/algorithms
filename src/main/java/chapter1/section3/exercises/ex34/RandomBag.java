package chapter1.section3.exercises.ex34;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Random;


public class RandomBag<Item> implements Iterable<Item> {

    private static Random rand = new Random();

    private int size = 0;

    private Item[] a = (Item[]) new Object[2];

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item){
        if(size == a.length){
            resize(a.length * 2);
        }
        a[size++] = item;
    }

    private void resize(int capacity){
        Item[] newArray = (Item[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            newArray[i] = a[i];
        }
        a = newArray;
    }


    @Override
    public Iterator<Item> iterator() {
//        return new LowEfficientRandomBagIterator();
        return new RandomBagIterator();
    }

    /**
     * 它的主要问题是，随着next()的调用，随机数发生器产生符合要求的随机数的概率会大大降低，使得总体效率不高。
     */
    private class LowEfficientRandomBagIterator implements Iterator<Item> {
        BitSet bitset = new BitSet(size);
        int visited = 0;
        @Override
        public boolean hasNext() {
            return visited < size;
        }

        @Override
        public Item next() {
            int index;
            while(true){
                int randomNum = rand.nextInt(size);
                if(!bitset.get(randomNum)){
                    bitset.set(randomNum);
                    index = randomNum;
                    break;
                }
            }
            return a[index];
        }
    }

    /**
     * http://www.cnblogs.com/liuweilinlin/archive/2013/09/21/3331611.html
     * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
     * 可以证明其随机性：
     * 如任何一个元素最终位置为0的概率为1/n
     * 任何一个元素的最终位置为1的概率为 第一轮它没有被选中放在0位置，第二轮它被选中放在1位置。即 (n-1)/n * 1/(n-1) = 1/n
     * 可证明所有元素最终落在任何位置的概率都为1/n
     */
    private class RandomBagIterator implements Iterator<Item> {
        private final Item[] arrayCopy;
        private int i = 0;
        public RandomBagIterator() {
            arrayCopy = (Item[]) new Object[size];
            for(int i = 0; i < size; i ++) {
                arrayCopy[i] = a[i];
            }

            for(int i = 0; i < size - 1; i++){
                int toSwap = i + rand.nextInt(size - i);
                Item temp = arrayCopy[i];
                arrayCopy[i] = arrayCopy[toSwap];
                arrayCopy[toSwap] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return i == size;
        }

        @Override
        public Item next() {
            return arrayCopy[i++];
        }
    }
}
