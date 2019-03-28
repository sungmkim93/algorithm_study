package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*구역의 갯수: 각 queue에 포함 될때, number을 센다.
최악의 비교의 경우를 생각한다면??....*
/bfs 에 queue에 있는걸 또 넣어준다?? -> 시간초과... -> visit를 true해주는 경우를 잘 생각
 */
public class SafeArea {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        boolean[] isExist = new boolean[101];
        int min = 100;
        int max = 0;
        int [][] map = new int[N][N];
        for(int i=0;i<N;i++){
            String[] tmpStr = bufferedReader.readLine().split(" ");
            for(int j=0;j<N;j++){
                int tmpNum = Integer.parseInt(tmpStr[j]);
                isExist[tmpNum] = true;
                if(max < tmpNum)
                    max = tmpNum;
                if(min > tmpNum)
                    min = tmpNum;
                map[i][j] = tmpNum;
            }
            isExist[min-1] = true;
        }
        System.out.println(safetyNum(map,isExist,min,max));
    }
    static int safetyNum(int[][] map,boolean[] isExist,int min,int max){
        int maxArea = 0;
        for(int i = min-1;i <max;i++){
           int num = bfs(map,i);
            if(isExist[i])
                if(maxArea < num)
                    maxArea = num;
        }
        return maxArea;
    }
    private static int bfs(int[][] map, int rainfall){
        int N = map.length;
        boolean[][] visit = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        int areaNum = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int i = 0; i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] > rainfall && !visit[i][j]){
                    queue.add(new Node(i,j));       //시작 큐
                    visit[i][j] = true;
                    areaNum++;
                    while(!queue.isEmpty()){
                        Node tmp = queue.poll();
                        int tx = tmp.x;
                        int ty = tmp.y;
                        for(int a = 0;a<4;a++){
                            int bx = tx+dx[a];
                            int by = ty+dy[a];
                            if(isBoundry(map,bx,by)){
                                if(!visit[bx][by] && map[bx][by] > rainfall){
                                    queue.add(new Node(bx,by));
                                    visit[bx][by] = true;
                                }
                            }

                        }

                    }

                }
            }
        }
        return areaNum;
    }
    private static boolean isBoundry(int[][] map,int x,int y){
        return x>=0 && x<map.length && y>=0 && y <map.length;
    }
    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
