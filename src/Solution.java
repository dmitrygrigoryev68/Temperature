import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {

// generate N
        int N = 0;

        for (int i = 0; i < 100; i++) {
            N = ThreadLocalRandom.current().nextInt(8, 199);
            if (N % 4 == 0) break;
        }
 //generate T
        int[] T = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = ThreadLocalRandom.current().nextInt(-1000, 999);
        }
//Outpun no console
        System.out.println(solution(T,N));
    }

    public static String solution(int[] T,int N) {
//initiate seasonal temperature array
        int [] seasonArr = new int [N/4];
//initiate array of differences
        int [] substrArr = new int [4];
        int max = 0;
//create seasonal temperature array and array of differences
        for (int j = 0; j < N/4; j++) {
            seasonArr[j]=T[j];}
            substrArr[0] = compare(seasonArr);

        for (int j = N/4; j < N/2; j++) {
            seasonArr[j - N/4]=T[j];}
            substrArr[1] = compare(seasonArr);

        for (int j = N/2; j < N/4*3; j++) {
            seasonArr[j - N/2] = T[j];}
            substrArr[2] = compare(seasonArr);

        for (int j = N/4*3; j < N; j++) {
            seasonArr[j - N/4*3]=T[j];}
            substrArr[3] = compare(seasonArr);

        for (int i = 0; i < 4; i++) {
            if (substrArr[i]>substrArr[max]){
                max = i;
            }
        }

        switch (max){
            case 0: return"WINTER";
            case 1: return"SPRING";
            case 2: return"SUMMER";
            case 3: return"AUTUMN";
            default: return "WRONG DATA";
        }
    }

    public static int compare(int compareArr[]){
        int min = 0, max = 0;
        for (int i =0 ; i < compareArr.length; i++) {
            if (compareArr[i] < compareArr [min]){
                min = i;
            }
            if (compareArr[i] > compareArr[max]){
                max = i;
            }
        }
         return (compareArr[max] - compareArr[min]);
    }
}