package Mathmatics;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] a = new int[number];
        int[] b = new int[number];
        for(int i=0;i<number;i++){
            a[i] = input.nextInt();
            b[i] = input.nextInt();
        }
        for(int i=0;i<number;i++){
            if(i != number-1)
                System.out.println(LCM(a[i],b[i]));
            else
                System.out.print(LCM(a[i],b[i]));
        }
    }

    static int LCM(int a, int b){
        int gcd = GCD(a, b);
        return (a*b)/gcd;
    }

    static int GCD(int a, int b){
        if(a == 1 || b == 1)
            return 1;
        if(b == 0){
            return a;
        }else{
            return GCD(b, a%b);
        }
    }
}
