package permutation;

import java.util.Scanner;

/**
 * input: 첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.
 * output: 첫째 줄에 입력으로 주어진 순열의 이전에 오는 순열을 출력한다. 만약, 사전순으로 가장 처음에 오는 순열인 경우에는 -1을 출력한다.
 * 7 2 3 6 4 5 1
 * 7 2 3 6 5 1 4
 * 7 2 3 6 5 4 1
 * 7 2 4 1 3 5 6
 * 1. A[i-1] > A[i] 인 가장 큰 i를 찾는다. 뒷부분이 오름차순이므로 (뒤에서부터 오면서 증가하는 부분을 찾는다.)
 * 2. j>=i && A[i-1] > A[j]인 가장 큰 j를 찾는다.
 * 3. swap(A, i-1, j)
 * 4. Sort(A, i, size) 내림차순
 * 시간 복잡도: O(N) N=size
 */
public class PreviousPermutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++)
            array[i] = input.nextInt();

        int numI = size-1;
        int numJ = size-1;

        while(numI > 0 && array[numI-1] < array[numI]){ // 1
            numI--;
        }
        if(numI == 0){          //num <= 0 이 실수방지로 더 좋다
            System.out.println("-1");
            return;
        }

        while(numJ >= numI && array[numI-1] < array[numJ]){ // 2
            numJ--;
        }

        swap(array, numI-1, numJ); // 3

        numJ = size-1;              // 4
        while(numI < numJ){
            swap(array,numI,numJ);
            numI++;
            numJ--;
        }

        for(int i=0; i<size; i++){
            if(i>0)
                System.out.print(" ");
            System.out.print(array[i]);
        }
    }

    static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
