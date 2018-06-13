package chapter1.section4.exercises;

import java.util.Random;

//如果其中有一个操作数是INFINITY呢？无限做除了乘以0意外的运算，结果还是无限
//可以使用Double.isInfinite来判断。
public class Ex17 {
    public static void farestPair(double[] a){
        if(a == null || a.length < 2)
            return;
        double smallest = Double.POSITIVE_INFINITY;
        double biggest = Double.NEGATIVE_INFINITY;
        for(double d : a){
            if(d < smallest)
                smallest = d;
            else if(d > biggest)
                biggest = d;
        }
        double x = Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY;
        System.out.println(x);
//        assert(Double.POSITIVE_INFINITY - Double.NEGATIVE_INFINITY == Double.POSITIVE_INFINITY);
        System.out.println("farest pair is " + smallest + " " + biggest);
    }


    public static void main(String[] args){
        Random rand = new Random();
        int n = 100;
        double[] a = new double[n];
        for(int i = 0; i < n; i++){
            a[i] = rand.nextInt(n*100);
        }
        farestPair(a);
    }
}
