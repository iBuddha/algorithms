package chapter1.section4.exercises;

//4-sum
public class Ex14 {
    public static void fourSum(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                for(int k = j + 1; k < a.length; k++){
                    for(int l = k + 1; l < a.length; l++){
                        if(a[i] + a[j] + a[k] + a[l] == 0)
                            System.out.printf("%s %s %s %s\n", a[i], a[k], a[j], a[l]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[400];
        for(int i = 0; i < 400; i++){
            a[i] = i - 100;
        }
        fourSum(a);
    }

}
