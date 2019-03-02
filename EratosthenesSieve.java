package Mathmatics;

import java.util.Scanner;

public class EratosthenesSieve {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int N = input.nextInt();
        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[1] = true;                   //1 is NOT prime number
        for(int i = 2; i < N; i++){
            if(!isNotPrime[i]){
                int j = 2;
                while((i*j) <= N){
                    isNotPrime[i*j] = true;     // the number is NOT prime number
                    j++;
                }
            }
        }
        for(int i = M; i <= N; i++)
            if(!isNotPrime[i])
                System.out.println(i);

    }

}
