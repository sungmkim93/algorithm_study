package Mathmatics;

import java.util.Scanner;

public class SumOfGCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        for(int i = 0; i < number; i++){
            int testNum = input.nextInt();
            int[] testCase = new int[testNum];
            for(int j = 0; j < testCase.length; j++){
                testCase[j] = input.nextInt();
            }
            System.out.println(sumOfGCD(testCase));
        }
    }

    public static long sumOfGCD(int[] arr){
        long sum = 0;
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                sum += gcd(arr[i],arr[j]);
            }
        }
        return sum;
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}
