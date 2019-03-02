package Mathmatics;

import java.util.Scanner;

public class GCDandLCM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int second = input.nextInt();

        int GreatestCommonDivisor = GCD(first, second);
        System.out.println(GreatestCommonDivisor);
        System.out.println((first*second)/GreatestCommonDivisor);
    }

    static int GCD(int f, int s){
        if(s == 0) {
            return f;
        }else{
            return GCD(s, f % s);
        }
    }

    static int GCD2(int f, int s){
        int tmp;
        while(s != 0){
            tmp = f % s;
            f = s;
            s = tmp;
        }
        return f;
    }
}

