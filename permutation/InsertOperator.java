package permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * input: 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100)
 * 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
 * output: 첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다.
 * 최댓값과 최솟값은 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다.
 * 또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
 */
public class InsertOperator {

    static boolean nextPermutation(int[] a){
        int i = a.length-1;
        while(i > 0 && a[i-1] >= a[i])
            i--;
        if(i <= 0)
            return false;

        int j = a.length-1;
        while(j>=i && a[i-1] >= a[j])
            j--;

        swap(a, i-1, j);

        j = a.length -1;
        while(i < j){
            swap(a, i, j);
            i++;
            j--;
        }
        return true;
    }

    static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static int[] makeOperator(int[] a, int plus, int min, int mul, int div){
        int[] operator = new int[a.length-1];
        for(int i=0; i<operator.length; i++){
            if(plus > 0){
                operator[i] = 0;        // '+'
                plus --;
                continue;
            }
            if(min > 0){                // '-'
                operator[i] = 1;
                min--;
                continue;
            }
            if(mul > 0){                // '*'
                operator[i] = 2;
                mul--;
                continue;
            }
            if(div > 0){                // '/'
                operator[i] = 3;
                div--;
                continue;
            }
        }

        /*
        int k = 0;
        for(int i=0; i<4; i++){
            int cnt = input.nextInt();
            for(int k=0; k<cnt; k++){
                operator[k++] = i;
            }
        }
         */
        return operator;
    }

    static void calculate(int[] a, int[] op){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = a[0];
        do{
            for(int i=1; i<a.length; i++){
                if(op[i-1] == 0)
                    sum = sum + a[i];
                else if(op[i-1] == 1)
                    sum = sum - a[i];
                else if(op[i-1] == 2)
                    sum = sum * a[i];
                else if(op[i-1] == 3){
                    if(sum < 0){
                        sum = Math.abs(sum) / a[i];
                        if(sum > 0)
                            sum = -sum;
                    }else
                        sum = sum / a[i];
                }
            }
            if(min > sum)
                min = sum;
            if(max < sum)
                max = sum;
            sum = a[0];
        }while (nextPermutation(op));
        System.out.println(max);
        System.out.println(min);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++)
            array[i] = input.nextInt();
        int plus = input.nextInt();
        int minus = input.nextInt();
        int multiply = input.nextInt();
        int division = input.nextInt();
        int[] operator = makeOperator(array, plus, minus, multiply, division);
        calculate(array, operator);
    }
}
