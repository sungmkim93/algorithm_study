package permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * input: 첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.
 * output: 첫째 줄에 입력으로 주어진 순열의 다음에 오는 순열을 출력한다. 만약, 사전순으로 마지막에 오는 순열인 경우에는 -1을 출력한다.
 * Algorithm
 * 1. A[i-1] < A[i] 인 가장 큰 i를 찾는다. 가장 큰!!!! 뒤에서 부터 !!
 * 2. j>=i, A[i] < A[j]인 가장 큰 j를 찾는다.  가장 큰!!!! 뒤에서 부터!!
 * 3. swap(A[i-1], A[j])
 * 4. A를 i 부터 A.length-1 까지 Sort 오름차순
 * 시간 복잡도: O(N) N=size
 */
public class NextPermutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++)
            array[i] = input.nextInt();
        for(int i = size-1; i >= 0; i--){
            if(i == 0) {//내림차순 일때(즉, 가장 큰 순열 일 때)
                System.out.println("-1");
                return;
            }
            if(array[i-1] < array[i]){      // i-1를 찾기
                for(int j = size-1; j >= i; j--){        // j찾기
                    if(array[j] > array[i-1]){
                        swap(array,i-1,j);
                        break;
                    }
                }
                Arrays.sort(array,i,size);
                break;
            }
        }
        for(int i=0; i<size; i++){
            if(i > 0)
                System.out.print(" ");
            System.out.print(array[i]);
        }
    }

    static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
