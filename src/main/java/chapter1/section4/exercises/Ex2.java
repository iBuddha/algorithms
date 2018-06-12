package chapter1.section4.exercises;

import std.In;
import std.StdOut;

/**
 * 修改ThreeSum，正确处理两个较大的int值可能溢出的情况。
 */
public class Ex2 {
    public static int count(int[] a) {  // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    //在此修改，当两个大的整数相加，会正溢出。当两个负数相加，会负溢出
 //TODO: 确认这种判断方式是正确的。
    public static int count2(int[] a) {  // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++){
                    if(a[i] > 0 && a[j] > 0 && a[i] + a[j] < 0)
                        continue;
                    else if(a[i] < 0 && a[j] < 0 && a[i] + a[j] > 0)
                        continue;
                    else if(a[i] + a[j] + a[k] == 0){
                        cnt ++;
                    }
                }
        return cnt;
    }
}
