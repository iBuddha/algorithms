package chapter1.section4.exercises;


import std.StdOut;

/**
 * 编写一个程序，给定一个含有N个不同整数的数组，找到一个局部最小元素，满足a[i] < a[i-1]且a[i] < a[i+1]的索引i。
 * 程序在最坏情况下所需的比较次数为~2lgN。
 */
public class Ex18 {
    public static int localMinimum(int[] a, int lo, int hi) {
        if (lo > hi)
            return -1;
        else if (lo == hi) {
            return lo;
        } else if (lo + 1 == hi) {
            if (a[lo] < a[hi])
                return lo;
            else
                return hi;
        } else {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < a[mid + 1] && a[mid] < a[mid - 1])
                return mid;
            else if (a[mid - 1] < a[mid])
                return localMinimum(a, lo, mid - 1);
            else
                return localMinimum(a, mid + 1, hi);
        }
    }

    public static int localMinimum(int[] a) {
        return localMinimum(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] array1 = {10, -9, 20, 25, 21, 40, 50, -20};
        int[] array2 = {-4, -3, 9, 4, 10, 2, 20};
        int[] array3 = {5, -3, -5, -6, -7, -8};
        int[] array4 = {5};
        int[] array5 = {10, 20};
        int[] array6 = {7, 20, 30};

        int localMinimum1 = localMinimum(array1);
        int localMinimum2 = localMinimum(array2);
        int localMinimum3 = localMinimum(array3);
        int localMinimum4 = localMinimum(array4);
        int localMinimum5 = localMinimum(array5);
        int localMinimum6 = localMinimum(array6);

        StdOut.println("Local Minimum: " + localMinimum1 + " Expected: 1 or 7");
        StdOut.println("Local Minimum: " + localMinimum2 + " Expected: 3 or 0 or 5");
        StdOut.println("Local Minimum: " + localMinimum3 + " Expected: 5");
        StdOut.println("Local Minimum: " + localMinimum4 + " Expected: 0");
        StdOut.println("Local Minimum: " + localMinimum5 + " Expected: 0");
        StdOut.println("Local Minimum: " + localMinimum6 + " Expected: 0");
    }
}
