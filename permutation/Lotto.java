package permutation;

import java.util.Scanner;

/**
 * input: 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 * 각 테스트 케이스는 한 줄로 이루어져 있다. 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
 * S의 원소는 오름차순으로 주어진다. 입력의 마지막 줄에는 0이 하나 주어진다.
 * output: 각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다. 각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
 *
 */
public class Lotto {
    static boolean nextpermutation(int[] a){
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i])
            i--;
        if(i == 0) // i<=0
            return false;
        int j = a.length-1;
        while(i <= j && a[i-1] >= a[j])
            j--;
        swap(a, i-1, j);
        j = a.length-1;
        while (i < j){
            swap(a, i , j);
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
    static void printLotto(int[] a){
        int k = a.length;
        int[] permutation = new int[k];
        for(int i=0; i<k; i++)
            permutation[i] = 1;     //1 이 선택X
        for(int i=0; i<6; i++)
            permutation[i] = 0;     //0 이 선택
        do{
            for(int j = 0; j<k; j++){
                if(permutation[j] == 0)
                    System.out.print(a[j]+" ");
            }
            System.out.println();
        }while (nextpermutation(permutation));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        while((size = input.nextInt()) != 0){
            int[] array = new int[size];
            for(int i=0; i<size; i++)
                array[i] = input.nextInt();
            printLotto(array);
            System.out.println();
        }
    }
}
