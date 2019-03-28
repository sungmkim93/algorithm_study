package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * bfs 는 시작 정점마다 cost 최단거리를 탐색하는 cost가 다르다...
 * **/
public class TreasureIsland {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int row = Integer.parseInt(strings[0]);
        int column = Integer.parseInt(strings[1]);
        char[][] map = new char[row][column];
        for(int i=0;i<row;i++){
            String tmp = bufferedReader.readLine();
            for(int j=0;j<column;j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        System.out.println(calShortestPathTime(map));
    }
    static int calShortestPathTime(char[][] map){
        int max =0;        //이동하는 시간
        int num;     //각 육지별 이동거리 값 저장 변수
        int row = map.length;
        int column = map[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map[i][j] == 'L'){
                    num = bfs(i,j,map);
                    if(max<num)
                        max = num;
                }
            }
        }
        return max;
    }
    private static int bfs(int x, int y,char[][] map){          //(i,j)를 시작정점으로 하여 최소값 return
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int row = map.length;
        int column = map[0].length;
        boolean[][] visit = new boolean[row][column];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        Node tmpNode = null;
        while(!queue.isEmpty()){
            tmpNode = queue.poll();
            if(visit[tmpNode.x][tmpNode.y])
                continue;
            visit[tmpNode.x][tmpNode.y] =true;
            for(int i=0;i<4;i++){
                int bx = tmpNode.x+dx[i];
                int by = tmpNode.y+dy[i];
                if(isBoundry(bx,by,map)){
                    if(!visit[bx][by] && map[bx][by]=='L'){
                        queue.add(new Node(bx,by,tmpNode.cost+1));
                    }
                }
            }
        }
        return tmpNode.cost;
    }
    private static boolean isBoundry(int x, int y,char[][] map){
        return x>=0 && x<map.length && y>=0 && y <map[0].length;
    }
    static class Node{
        int x,y,cost;
        Node(int x,int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
