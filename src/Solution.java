

public class Solution {

    public static void main(String[] args) {

        int minT = -1000;
        int maxT =  1000;
        //int N = createN();
        int N = 12;
        int[] T = new int[N];

        for (int i = 0; i < N; i++) {
          //  int k = (int) (Math.random() * 1000);
            T[i] = minT + (int) (Math.random() * 1000);
            System.out.println(" "+ i +" "  +T[i]);


        }





        System.out.println(solution(T,N));

    }

    public static String solution(int[] T, int N) {

        int [] seasonArr = new int [N/4];
        int [] substrArr = new int [4];
        int max = 0;


        for (int j = 0; j < N; j++) {
            if (j>=0&&j<N/4){
                seasonArr[j]=T[j];
                substrArr[1] = compare(seasonArr);
            }
            if (j>=N/4&&j<N/2) {
                seasonArr[j-N/4]=T[j];
                substrArr[2] = compare(seasonArr);
            }
            if (j>=N/2&&j<N/4*3) {
                seasonArr[j-N/2]=T[j];
                substrArr[3] = compare(seasonArr);
            }
            if (j>=N/4*3&&j<N) {
                seasonArr[j-N/4*3]=T[j];
                substrArr[3] = compare(seasonArr);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (substrArr[i]>substrArr[max]){
                i = max;
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
                System.out.println();
                    min = i;
            }
            if (compareArr[i]>compareArr[max]){
                max = i;
            }

        }
        System.out.println("difference = " + (max-min));
         return (max-min);

    }
}