package Mathmatics;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int primeCount = 0;
        while(count-- > 0){
            int digit = input.nextInt();
            if(isPrimeNumber(digit))
                primeCount++;
        }
        System.out.println(primeCount);
    }
    public static boolean isPrimeNumber(int number){
        if(number < 2){
            return false;
        }else{
            for(int i = 2; i*i <= number; i++){
                if(number % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}
