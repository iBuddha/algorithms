package other;

class Expect {
    public static void main(String[] args) {
        int N = 100;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                 for(int k = 0; k < 100; k++) {
                     int max = Math.max(Math.max(i, j), k);
                     sum += max;
                     count += 1;
                 }
            }
        }
        int avg = sum / count;
        System.out.println(avg);
    }
}