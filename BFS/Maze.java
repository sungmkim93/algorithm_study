package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = bufferedReader.readLine().split(" ");
        int x = Integer.parseInt(first[0]);
        int y = Integer.parseInt(first[1]);
        int[][] mazeInfo = new int[x][y];
        for(int i=0;i<x;i++){
            String tmp = bufferedReader.readLine();
            for(int j=0;j<y;j++)
                mazeInfo[i][j] = Character.getNumericValue(tmp.charAt(j));
        }
        System.out.println(shortest(mazeInfo,x,y));
    }
    public static int shortest(int[][] maze,int x, int y){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[x][y];
        int[] dx = {-1,0,1,0};              //x 좌표의 4방향 값 확인
        int[] dy = {0,1,0,-1};               //y 좌표의 4방향 값 확인
        queue.add(new Node(0,0,1));
        int qx=0,qy=0;
        int bx,by;
        Node tmp = null;
        while(qx != x-1 || qy != y-1){
            tmp = queue.poll();
            qx = tmp.x;
            qy = tmp.y;
            if(visit[qx][qy])
                continue;
            visit[qx][qy] = true;
            for(int i=0;i<4;i++){
                bx = qx+dx[i];
                by = qy+dy[i];
                if(isBoundry(maze,bx,by) && maze[bx][by] == 1)
                    queue.add(new Node(bx,by,tmp.length+1));
            }
        }
        return tmp.length;
    }
    private static boolean isBoundry(int[][] maze,int x,int y){
        return x>=0 && x<maze.length && y>=0 && y<maze[x].length;
    }
    static class Node{
        int x,y,length;
        Node(int x,int y,int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}
