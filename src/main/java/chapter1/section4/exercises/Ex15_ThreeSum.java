package chapter1.section4.exercises;

import std.StdOut;

import java.util.Arrays;
import java.util.Random;

/**
 * 考虑到重复元素
 */
public class Ex15_ThreeSum {
    public static void fastThreeSum(int[] a) {
        if (a == null)
            return;
        //lastIK为上一次j = i + 1时 所有a[i] + a[j] + a[k] > 0时候最小的k。记录它使得不必每次给j赋值以后将k重置到length-1，而是使得k成为一个始终
        //递减的值。使得算法复杂度的上界低于O(n^2)
        int lastIK = a.length - 1;

        int cnt = 0;
        int operationCount = 0;
        //在所有三元组中i是索引最小的元素，j是索引第二大的元素,k是索引最大的元素
        for (int i = 0; i < a.length - 2; i++) {
            int k = lastIK;
            for (int j = i + 1; j < k; j++) {
                while (j < k) {
                    operationCount++;
                    int sum = a[i] + a[j] + a[k];
                    if (sum > 0) {
                        if(j == i + 1)
                            lastIK = k;
                        k--;
                    } else if (sum < 0)
                        break;
                    else if(a[k] != a[j]){
                        int jCount = 1;
                        while (j + 1 < k && a[j + 1] == a[j]) {
                            operationCount++;
                            j++;
                            jCount++;
                        }

                        int kCount = 1;
                        while (j < k - 1 && a[k - 1] == a[k]) {
                            k--;
                            kCount++;
                            operationCount++;
                        }
                        cnt += jCount * kCount;
//                        for (int l = 0; l < jCount * kCount; l++)
//                            System.out.printf("%s %s %s \n", a[i], a[j], a[k]);
                        k--;
                    } else {
                        // a[j] == a[k]
                        int ajNumber = 1;
                        //当此循环结束时，k == j，所以上一层for循环也会立即退出
                        while(k > j && a[--k] == a[k+1]) {
                            ajNumber++;
                            operationCount++;
                        }
                        cnt += (ajNumber - 1) * ajNumber / 2;
                    }
                }
            }
        }
        StdOut.println("count: " + cnt);
        StdOut.println("operation count: " + operationCount);
    }

    public static void brutalForceThreeSum(int[] a) {
        if (a == null)
            return;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
//                        System.out.printf("%s %s %s \n", a[i], a[j], a[k]);
                        count++;
                    }
                }
            }
        }

        StdOut.println("count: " + count);

    }

    private static int[] randomInt(int min, int max, int count) {
        Random rand = new Random();
        int upper = max - min;
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            a[i] = rand.nextInt(upper) + min;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = randomInt(-100, 100, 1000);
//        int[] a = new int[]{0, 0, 0, 0, 0};
        Arrays.sort(a);
//        printArray(a);
        brutalForceThreeSum(a);
        fastThreeSum(a);
    }

    private static void printArray(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
