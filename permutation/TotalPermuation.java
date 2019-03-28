package permutation;

import java.util.Scanner;

/**
 * input: 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
 * output: 첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.
 * 1 2 3 4 5 6 7
 * ...
 * 7 6 5 4 3 2 1
 * 시간복잡도: O(N) = NextPermuation * O(N!) = O(N*N!)
 */
public class TotalPermuation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        for(int i=0;i<N;i++){
            array[i] = i+1;
//            if (i > 0)
//                System.out.print(" ");
//            System.out.print(array[i]);
        }
/*        System.out.println();
        while(nextPermutation(array, N)) {
            for (int i = 0; i < N; i++) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(array[i]);
            }
            System.out.println();
        }*/
        do{
            for (int i = 0; i < N; i++) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(array[i]);
            }
            System.out.println();
        }while(nextPermutation(array, N));
    }

    static boolean nextPermutation(int[] array, int N){
        int i = N-1;
        while(i > 0 && array[i-1] > array[i])
            i--;
        if(i <= 0)
            return false;

        int j = N-1;
        while(j >= i && array[i-1] > array[j])
            j--;

        swap(array, i-1, j);

        j = N-1;
        while(i < j){
            swap(array, i, j);
            i++;
            j--;
        }
        return true;
    }

    static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
