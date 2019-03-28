package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* N: 정점의 갯수, M: 간선의 갯수, V: 탐색을 시작할 정점 번호
* M개의 줄만큼 간선의 정보가 입력 -> 중복된 간선은 하나로 처리 그리고 양방향
* */
public class DFSandBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] graphInfo = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(graphInfo[0]);     //vertex
        int M = Integer.parseInt(graphInfo[1]);     //edge
        int V = Integer.parseInt(graphInfo[2]);     //start vertex
        boolean[][] graph = new boolean[N+1][N+1];  //1~N 까지 표현하는 graph (0은 무시)

        for(int i=0;i<M;i++){
            String[] tmp = bufferedReader.readLine().split(" ");
            int tx = Integer.parseInt(tmp[0]);
            int ty = Integer.parseInt(tmp[1]);
            addEdge(graph,tx,ty);
        }
        boolean[] visit = new boolean[N+1];
        dfs(graph,visit,V);
        System.out.println(dfsStr);       //dfs
        System.out.println(bfs(graph,V));       //bfs
        
    }
    static String dfsStr ="";

    static void dfs(boolean[][] graph,boolean[] visit,int start){
        int N = visit.length;
        visit[start] = true;
         dfsStr+= start+" ";

        for(int i=1;i<N;i++) {
            if (start == i)
                continue;
            if (graph[start][i] && !visit[i])
                dfs(graph, visit, i);

        }
    }

    static String bfs(boolean[][] graph,int start){
        String visitStr = "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start));
        int N = graph.length;
        boolean[] visit = new boolean[N];         //visit[0]은 안써~
        visit[start] = true;
        Node tmp = null;
        while(!queue.isEmpty()){ 
            tmp = queue.poll();
            visitStr += tmp.vertexNum+" ";
            for(int i=1;i<N;i++){
                if(tmp.vertexNum == i)
                    continue;
               if(graph[tmp.vertexNum][i] && !visit[i]){
                   queue.add(new Node(i));
                   visit[i] = true;
               }
            }
        }
        return visitStr;
    }
    private static void addEdge(boolean[][] graph,int x, int y){
        graph[x][y] = true;
        graph[y][x] = true;
    }

    static class Node{
        int vertexNum;
        Node(int vertexNum){
            this.vertexNum = vertexNum;
        }
    }
}
