package bruteForce;

import java.util.Scanner;

public class Tetromino {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = input.nextInt();
            }
        }
        int sum = 0;
        int tmp = 0;
        for(int i=0;i<N; i++){
            for(int j=0; j<M; j++){
                if(j+3 < M){
                    tmp = arr[i][j]+ arr[i][j+1]+ arr[i][j+2]+ arr[i][j+3]; // 1
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+3 < N){
                    tmp = arr[i][j] + arr[i+1][j]+ arr[i+2][j] + arr[i+3][j];   // 2
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+1 < N && j+1 < M){
                    tmp = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];   // 3
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+2 < N && j+1 < M){
                    tmp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];    // 4
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+1 < N && j+2 < M){
                    tmp = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j+2];      // 5
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+2 < N && j+1 < M){
                    tmp = arr[i][j]+ arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];   // 6
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i-2 >= 0 && j+1 < M ){                                           // 7
                    tmp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-2][j+1];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i-1 >= 0 && j+2 < M){   //8
                    tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];//fault_1
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+1 < N && j+2 < M){   //9
                    tmp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+2 < N && j+1 < M){   //10
                    tmp = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+1 < N && j+2 < M){       //11
                    tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+2 < N && j+1 < M){   //12
                    tmp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i-1 >= 0 && j+2 < M){   //13
                   tmp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+1 < N && j+2 < M){   //14
                    tmp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1]+ arr[i+1][j+2];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i-2 >=0 && j+1 < M){   //15
                    tmp = arr[i][j] + arr[i-1][j] + arr[i-1][j+1] + arr[i-2][j+1];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i+1 < N && j+2 < M){   //16
                   tmp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i-2 >= 0 && j-1 >= 0){   //17
                    tmp = arr[i][j] + arr[i-1][j] + arr[i-2][j] + arr[i-1][j-1];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i-1 >= 0 && j+2 < M){   //18
                   tmp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i][j+2];
                    if(sum < tmp)
                        sum = tmp;
                }
                if(i-2 >= 0 && j+1 < M) {   //19
                    tmp = arr[i][j] + arr[i-1][j] + arr[i-2][j] + arr[i - 1][j + 1];
                    if (sum < tmp)
                        sum = tmp;
                }

            }
        }
        System.out.println(sum);

    }
}
