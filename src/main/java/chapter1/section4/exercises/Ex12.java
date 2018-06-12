package chapter1.section4.exercises;

import std.StdOut;

public class Ex12 {
    //这种解法的问题是最差情况下的时间复杂度是O(N+M)。可以用二分查找来减少最差情况下时间复杂度
    public static void printAllEqualPairs(int[] a, int[] b){
        if(a == null || b == null || a.length == 0 || b.length == 0)
            return ;
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                System.out.print(a[i] + " ");
                //难点在于这里需要处理重复的情况。
                while(i + 1 < a.length && a[i+1] == a[i])
                    i++;
                i++;
                j++;
            } else if(a[i] < b[j])
                i++;
            else j ++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 4, 5, 6, 8, 8};
        int[] b = new int[]{1, 1, 2, 2, 2, 2, 3, 5, 7, 8, 10, 10};
        StdOut.println("\nExpected: 1 2 5 8");
        printAllEqualPairs(a, b );
        int[] array1 = {-2, 1, 2, 2, 5, 6, 6, 8, 25};
        int[] array2 = {0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25};
        printAllEqualPairs(array1, array2);
        StdOut.println("\nExpected: 1 2 5 25");
    }
}
