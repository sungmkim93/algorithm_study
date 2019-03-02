package Mathmatics;

import java.util.Scanner;

public class Remainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();

        if(A >= 2 && A <= 10000 && B >= 2 && B <= 10000 && C >=2 && C <= 10000){
            System.out.println((A+B)%C);
            System.out.println((A%C + B%C)%C);
            System.out.println((A*B)%C);
            System.out.print((A%C * B%C)%C);
        }
    }
}
