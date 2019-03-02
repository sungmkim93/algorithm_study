package Mathmatics;

import java.util.Scanner;

public class GoldbachConjecture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] isNotPrime = new boolean[1000001];
        for(int i = 2; i*i <= 1000000; i++){
            if(!isNotPrime[i]){
                for(int j=i*2; j<= 1000000; j+=i){
                    isNotPrime[j] = true;
                }
            }
        }

        int number = input.nextInt();
        while(number != 0){
            for(int i = 2; i < number-1; i++){
                if(!isNotPrime[i] && !isNotPrime[number-i] && i%2 != 0 && (number-i)%2 != 0){
                    System.out.println(number + " = " + i + " + " + (number-i));
                    break;
                }
            }
            number = input.nextInt();
        }
    }
}
