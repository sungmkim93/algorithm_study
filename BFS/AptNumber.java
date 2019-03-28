package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AptNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[][] AptMap = new int[length][length];
        for(int i=0;i<length;i++){
            String tmp = bufferedReader.readLine();
            for(int j=0;j<length;j++){
                AptMap[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }
        makeAptNumber(AptMap,length);
    }
    public static void makeAptNumber(int[][] AptMap,int length){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[length][length];
        boolean[][] isInclude = new boolean[length][length];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int complexNumber = 0;
        ArrayList aptNumber = new ArrayList();
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(visit[i][j])
                    continue;
                if(AptMap[i][j] == 1){
                    complexNumber++;        //아파트 단지 갯수 증가
                    queue.add(new Node(i,j));
                    isInclude[i][j] = true;
                    int num= 0;
                    while(!queue.isEmpty()){
                        Node tmp = queue.poll();
                        num++;
                        int tx = tmp.x;
                        int ty = tmp.y;
                        visit[tx][ty] = true;
                        for(int k = 0;k<4;k++){
                            int bx = tx+dx[k];
                            int by = ty+dy[k];
                            if(isBoundry(bx,by,length)){
                                if(!isInclude[bx][by]&&!visit[bx][by] && AptMap[bx][by] == 1){
                                    queue.add(new Node(bx,by));
                                    isInclude[bx][by] = true;
                                }
                            }
                        }
                    }
                    aptNumber.add(num);     //단지별 아파트 갯수 출력
                }
            }
        }
        System.out.println(complexNumber);
        Collections.sort(aptNumber);
        for(int i =0;i<complexNumber;i++)
            System.out.println(aptNumber.get(i));
    }
    private static boolean isBoundry(int x,int y,int length){
        return x>=0 && x<length && y>=0 && y<length;
    }
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
