package permutation;

import java.util.Scanner;

/**
 * input: 첫째 줄에 도시의 수 N이 주어진다. (2 ≤ N ≤ 10) 다음 N개의 줄에는 비용 행렬이 주어진다.
 * 각 행렬의 성분은 1,000,000 이하의 양의 정수이며, 갈 수 없는 경우는 0이 주어진다. W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타낸다.
 * 항상 순회할 수 있는 경우만 입력으로 주어진다.
 * output: 첫째 줄에 외판원의 순회에 필요한 최소 비용을 출력한다.
 *
 * 1 2 3 4 = 0 1 2 3 으로 생각하고 풀어도 이 문제는 가능하다!(Computer는 0부터 시작이므로!)
 */
public class TravelingSalesmanProblem {
    static boolean nextPermutation(int[] a){
        int i = a.length-1;
        while(i>0 && a[i-1] > a[i])
            i--;
        if(i <= 0)
            return false;

        int j = a.length-1;
        while(j>=i && a[i-1] > a[j])
            j--;
        swap(a, i-1, j);

        j = a.length-1;
        while(i < j){
            swap(a, i, j);
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
    static int calculate(int[] a, int[][] weight){
        int sum = 0;
        for(int i=0; i<a.length-1; i++){
            sum += weight[a[i]][a[i+1]];
        }
        sum+=weight[a[a.length-1]][a[0]];
        return sum;
    }
    static boolean isPath(int[]a, int[][] weight){
        int check = 1;
        for(int i=0; i<a.length-1; i++){
            check *= weight[a[i]][a[i+1]];
        }
        check *= weight[a[a.length-1]][a[0]];

        if(check == 0)
            return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        for(int i=0; i<N; i++)
            array[i] = i;
        int[][] weight = new int[N][N];
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                weight[i][j] = input.nextInt();
            }
        }
        int min = 5000000; // int min = Integer.MAX_VALUE;
        do{
            if(isPath(array, weight)){
                int tmp = calculate(array, weight);
                if(min > tmp)
                    min = tmp;
            }
        }while(nextPermutation(array));

        System.out.println(min);

    }
}
