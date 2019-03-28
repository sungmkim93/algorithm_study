package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class OragnicCabbage {
    public static void main(String[] args) throws IOException {
        int caseNum;
        int M,N,K;     //(M,N) -> (N,M) K=cabbage length column = M, row = N
        int[][] farmLand;   //농지 저장
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        caseNum = Integer.parseInt(bufferedReader.readLine());
        while(caseNum>0){
            String[] farmInfo = bufferedReader.readLine().split(" ");
            M = Integer.parseInt(farmInfo[0]);
            N = Integer.parseInt(farmInfo[1]);
            K = Integer.parseInt(farmInfo[2]);
            farmLand = new int[N][M];
            for(int i=0;i<K;i++){
                int tM,tN;
                String[] tmp;
                tmp= bufferedReader.readLine().split(" ");
                tM = Integer.parseInt(tmp[0]);
                tN = Integer.parseInt(tmp[1]);
                farmLand[tN][tM] = 1;
            }
            System.out.println(bugNum(farmLand));
            caseNum--;
        }

    }
    static int bugNum(int[][] farmLand){
        int m = farmLand[0].length;
        int n = farmLand.length;
        int cabbageNum = 0;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j])
                    continue;
                if(farmLand[i][j] == 1){
                    queue.add(new Node(i,j));
                    cabbageNum++;
                }
                while(!queue.isEmpty()){
                    Node tmp = queue.poll();
                    int tx = tmp.x;
                    int ty = tmp.y;
                    visit[tx][ty] = true;
                    for(int a = 0;a<4;a++){
                        int bx = tx+dx[a];
                        int by = ty+dy[a];
                        if(isBoundry(farmLand,bx,by)){
                            if(!visit[bx][by] && farmLand[bx][by]==1){
                                queue.add(new Node(bx,by));
                            }
                        }
                    }
                }

            }
        }
        return cabbageNum;
    }
    private static boolean isBoundry(int[][] farmLand, int x,int y){
        return x>=0 && x<farmLand.length && y>=0 && y<farmLand[0].length;
    }
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
