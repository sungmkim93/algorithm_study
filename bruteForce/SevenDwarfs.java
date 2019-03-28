package bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarfs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++){
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        sum -= 100;
        int tmpI=0, tmpJ=0;
        exit_For:
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(arr[i] + arr[j] == sum){
                    tmpI = i;
                    tmpJ = j;
                    break exit_For;
                }
            }
        }

        for(int i=0;i<9;i++){
            if(i == tmpI || i == tmpJ)
                continue;
            System.out.println(arr[i]);
        }

    }
}
