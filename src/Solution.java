import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {

        int N = 0;
        for (int i = 0; i < 100; i++) {
            N = ThreadLocalRandom.current().nextInt(8, 199);
            if (N % 4 == 0) break;
        }
        int[] T = new int[N];
        for (int i = 0; i < N; i++) { T[i] = ThreadLocalRandom.current().nextInt(-1000, 999);

        }
        System.out.println(solution(T,N));
    }

    public static String solution(int[] T, int N) {

        int[] diff = new int[4];
        int max = 0;
        int maxIn = 0;
        int min = 0;
        int k = N/4;

        for (int i = 0; i < 4; i++) {
            for (int j = i * k ; j < (i + 1)* k; j++) {
                if (min > T[j]) {
                    min = T[j];
                }
                if (max < T[j]) {
                    max = T[j];
                }
            }
            diff[i] = max - min;
            max = 0;
            min = 0;
            if (diff[maxIn] < diff[i]){
                maxIn = i;
            }
        }
            switch (maxIn) {
            case 0:
                return "WINTER";
            case 1:
                return "SPRING";
            case 2:
                return "SUMMER";
            case 3:
                return "AUTUMN";
            default:
                return "WRONG DATA";
        }
    }
}