package chapter1.section4.exercises;

import java.util.Arrays;
import java.util.Random;

//double会溢出到Double.POSITIVE_INFINITY or Double.NEGATIVE_INFINITY，但不会折回来。这样就简单了很多
public class Ex16 {
    public static void nearestPair(double[] a) {
        if (a == null || a.length < 2)
            return;
        Arrays.sort(a);
        double lo = a[0];
        double hi = a[1];
        double smallestDistance = Math.abs(lo - hi);
        for (int i = 2; i < a.length; i++) {
            double distance = Math.abs(a[i] - a[i - 1]);
            if (distance < smallestDistance) {
                lo = a[i - 1];
                hi = a[i];
                smallestDistance = distance;
            }
        }
        System.out.printf("The nearest pair is %s and %s, with distance %s", lo, hi, smallestDistance);

    }


}
