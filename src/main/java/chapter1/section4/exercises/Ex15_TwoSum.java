package chapter1.section4.exercises;

public class Ex15_TwoSum {
    public static void fastTwoSum(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int count = 0;
        while (lo < hi) {
            int sum = a[lo] + a[hi];
            if (sum < 0) {
                lo++;
            } else if (sum > 0)
                hi--;
            else {
                int loCnt = 1;
                int hiCnt = 1;
                while (++lo < hi && a[lo] == a[lo - 1])
                    loCnt++;
                while (--hi > lo && a[hi] == a[hi + 1])
                    hiCnt++;
                count += loCnt * hiCnt;
            }
        }

        System.out.println("count: " + count);
    }

    public static void main(String[] args) {
        int[] a = new int[]{-5, -4, -4, -2, 0, 0, 1, 2, 4, 6};
        fastTwoSum(a);
    }
}
