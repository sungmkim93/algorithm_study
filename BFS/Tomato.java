package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
창고에 보관중인 토마토가 모두 익는 최소 일수구하기
1. N*M 의형태
2. 처음 1인 경우를 찾아라(익은 토마토의 갯수 = 시작 큐에 들어갈 좌표)
3. 좌표에 int형 day라는 변수 추가
4. -1로 둘려싸인 곳이 있을경우 -1을 리턴

* */
public class Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] boxSize = bufferedReader.readLine().split(" ");
        int M = Integer.parseInt(boxSize[0]);
        int N = Integer.parseInt(boxSize[1]);
        int[][] box = new int[N][M];
        boolean[][] state = new boolean[N][M];  //-1: empty, 0: don`t ripen, 1: ripen
        for(int i=0;i<N;i++){
            String[] tmp = bufferedReader.readLine().split(" ");
            for(int j=0;j<M;j++){
                int tmpNum = Integer.parseInt(tmp[j]);
                if(tmpNum == 1)
                    state[i][j] = true;
                box[i][j] = tmpNum;
            }
        }
        if(isLock(box))
            System.out.println(-1);
        else
            System.out.println(leastDay(box,state,N,M));

    }
    static int leastDay(int[][] box,boolean[][] state, int N, int M){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisit = new boolean[N][M];
        for(int i=0;i<N;i++){                   //시작 Queue를 채운다
            for(int j=0;j<M;j++){
                if(state[i][j])
                    queue.add(new Node(i,j,0));
            }
        }
        Node tmp = null;
        while(!queue.isEmpty()){
            tmp = queue.poll();
            int tx = tmp.x;
            int ty = tmp.y;
            for(int i=0;i<4;i++){
                int bx = tx+dx[i];
                int by = ty+dy[i];
                if(isBoundry(box,bx,by)){
                    if(box[bx][by] == 0 && !isVisit[bx][by]){
                        queue.add(new Node(bx,by,tmp.day+1));
                        isVisit[bx][by] = true;
                    }
                }
            }

        }
        return tmp.day;
    }
    private static boolean isBoundry(int[][] box,int x,int y){
        return x>=0 && x<box.length && y>=0 && y<box[0].length;
    }
     private static boolean isLock(int[][] box){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        boolean[] lock;
        for(int i=0;i<box.length;i++){
            for(int j=0;j<box[0].length;j++){
                if(box[i][j] == 0){
                    lock = new boolean[4];
                    for(int a=0;a<4;a++){
                        int bx = i+dx[a];
                        int by = j+dy[a];
                        if(isBoundry(box,bx,by))
                            if(box[bx][by] == 1 || box[bx][by] == 0)
                                lock[a] = true;
                    }
                    if(!lock[0]&&!lock[1]&&!lock[2]&&!lock[3])
                        return true;
                }
            }
        }
        return false;
    }
    static class Node{
        int x,y,day;
        Node(int x,int y,int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

}
