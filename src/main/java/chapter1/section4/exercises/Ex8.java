package chapter1.section4.exercises;

import java.util.Arrays;

//相等的整数对的数目
public class Ex8 {

    public static int pairNumber(int[] a) {
        if (a.length <= 1)
            return 0;
        Arrays.sort(a);
        int count = 0;
        int currentContinuous = 1;//当前连续相等整数的数量
        int pre = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == pre) {
                currentContinuous++;
            } else if (currentContinuous >= 2) {
                count += currentContinuous * (currentContinuous - 1) / 2;
                pre = a[i];
                currentContinuous = 1;
            }
        }

        if(currentContinuous >= 2)
            count += currentContinuous * (currentContinuous - 1) / 2;
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 3, 4, 4, 1, 2 };
        System.out.println(pairNumber(a));
    }
}
