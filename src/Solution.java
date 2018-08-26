

public class Solution {

    public static void main(String[] args) {

        int minT = -1000;
        int maxT =  1000;
        int N = createN();
        int[] T = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = minT + (int) (Math.random() * 1000);
            System.out.println(" "+ i +" "  +T[i]);
        }

        System.out.println(solution(T,N));

    }

    public static String solution(int[] T, int N) {

        int [] seasonArr = new int [N/4];
        int [] substrArr = new int [4];
        int max = 0;

        for (int j = 0; j < N/4; j++) {
            seasonArr[j]=T[j];}
            substrArr[0] = compare(seasonArr);
            System.out.println(substrArr[0]);
        for (int j = N/4; j < N/2; j++) {
            seasonArr[j-N/4]=T[j];}
            substrArr[1] = compare(seasonArr);
            System.out.println(substrArr[1]);
        for (int j = N/2; j < N/4*3; j++) {
            seasonArr[j-N/2]=T[j];}
            substrArr[2] = compare(seasonArr);
            System.out.println(substrArr[2]);
        for (int j = N/4*3; j < N; j++) {
            seasonArr[j-N/4*3]=T[j];}
            substrArr[3] = compare(seasonArr);
            System.out.println(substrArr[3]);

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
            default: return"";
        }
    }

    public static int createN() {
        int minN = 8;
        int maxN = 200;
        int N = 0;
        for (int i = 0; i < 100; i++) {
            N = minN + (int) (Math.random() * maxN);
            if (N % 4 == 0) break;
        }
        return N;
    }

    public static int compare(int compareArr[]){
        int min = 0, max = 0;
        for (int i =0 ; i < compareArr.length; i++) {
            if (compareArr[i]<compareArr[min]){
                    min = i;
            }
            if (compareArr[i]>compareArr[max]){
                max = i;
            }
        }
         return (compareArr[max]-compareArr[min]);
    }
}