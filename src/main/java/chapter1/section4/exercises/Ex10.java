package chapter1.section4.exercises;

/**
 * https://blog.csdn.net/daniel_ustc/article/details/17307937
 */
public class Ex10 {
    public static int binarySearch2(int[] a, int target, int lo, int hi){
        if(lo > hi)
            return -1;
        int midIndex = lo + (hi - lo) / 2;
        int mid = a[midIndex];
        if(target == mid){
            return findEqualSmallestIndex(a, target, lo, midIndex);
        } else if(target < mid){
            return binarySearch2(a, target, lo, mid - 1);
        } else {
            return binarySearch2(a, target, mid + 1, hi);
        }
    }

    /**
     *
     * @param a
     * @param lo
     * @param target
     * @return
     */
    private static int findEqualSmallestIndex(int[] a, int target, int lo, int hi){
        if(lo == hi || lo + 1== hi)
            return hi;
        int midIndex = lo + (hi - lo) / 2;
        if(a[midIndex] == target){
            return findEqualSmallestIndex(a, target, lo, midIndex);
        } else if(a[midIndex] < target){
            return findEqualSmallestIndex(a, target, midIndex + 1, hi);
        } else
            throw new RuntimeException("should never reach here"); // never reach
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 4, 4, 5, 5, 5, 5, 5,7, 8};
        System.out.println(binarySearch(a, 5, 0, a.length - 1));
    }

    //下面这个方法更好
    private static int binarySearch(int[] array, int element, int low, int high) {

        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (array[middle] < element) {
            return binarySearch(array, element, middle + 1, high);
        } else if (array[middle] > element) {
            return binarySearch(array, element, low, middle - 1);
        } else {

            int possibleSmallestIndex = binarySearch(array, element, low, middle - 1);
            if (possibleSmallestIndex == -1) {
                return middle;
            } else {
                return possibleSmallestIndex;
            }
        }
    }
}
