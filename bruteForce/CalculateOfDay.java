package bruteForce;

import java.util.Scanner;

public class CalculateOfDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int E = input.nextInt();
        int S = input.nextInt();
        int M = input.nextInt();
        int i = 1;
        int e=1, s=1, m=1;
        while(true){
            if(e == E && s == S && m == M){
                System.out.println(i);
                break;
            }
            i++;
            e++;
            s++;
            m++;

            if(e == 16)
                e = 1;
            if(s == 29)
                s = 1;
            if(m == 20)
                m = 1;
        }

        /**
         * Another idea!!
         * 1 <= E <= 15 -> 0 <= E-1 <= 14 (15로 나눈 나머지)
         * 1 <= S <= 28 -> 0 <= S-1 <= 27 (28로 나눈 나머지)
         * 1 <= M <= 19 -> 0 <= M-1 <= 18 (19로 나눈 나머지)
         * 각 년도에 1을 뺀다는 것은 실제 년도에서 1을 뺀 것과 같은 의미!
         */
        int year = 0;
        while(year < 7980){
            if(year % 15 == E-1 && year % 28 == S-1 &&  year % 19 == M-1){
                System.out.println(year+1);
                break;
            }
            year++;
        }

    }
}
