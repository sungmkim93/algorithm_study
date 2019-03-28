package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class OragnicCabbage_version2 {
    public static void main(String[] args) throws IOException {
        int caseNum;
        int M, N, K;     //(M,N) -> (N,M) K=cabbage length column = M, row = N
        Node[] farmLand;   //농지 저장
        boolean[][] isHere;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        caseNum = Integer.parseInt(bufferedReader.readLine());
        while (caseNum > 0) {
            String[] farmInfo = bufferedReader.readLine().split(" ");
            M = Integer.parseInt(farmInfo[0]);
            N = Integer.parseInt(farmInfo[1]);
            K = Integer.parseInt(farmInfo[2]);
            farmLand = new Node[K];
            isHere = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                int tM, tN;
                String[] tmp;
                tmp = bufferedReader.readLine().split(" ");
                tM = Integer.parseInt(tmp[0]);
                tN = Integer.parseInt(tmp[1]);
                farmLand[i] = new Node(tN, tM);
                isHere[tN][tM] = true;
            }
            System.out.println(bugNum(farmLand, isHere, M, N));
            caseNum--;
        }
    }

    static int bugNum(Node[] farmLand, boolean[][] isHere, int M, int N) {
        Queue<Node> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int bugCount = 0;
        boolean[][] isVisit = new boolean[N][M];
        for (int i = 0; i < farmLand.length; i++) {
            if (isVisit[farmLand[i].x][farmLand[i].y])
                continue;
            queue.add(farmLand[i]);
            isVisit[farmLand[i].x][farmLand[i].y] = true;
            bugCount++;
            while (!queue.isEmpty()) {
                Node tmp = queue.poll();
                int tx = tmp.x;
                int ty = tmp.y;
                for (int j = 0; j < 4; j++) {
                    int bx = tx + dx[j];
                    int by = ty + dy[j];
                    if (isBoundry(bx, by, M, N))
                        if (!isVisit[bx][by] && isHere[bx][by]) {
                            queue.add(new Node(bx, by));
                            isVisit[bx][by] = true;
                        }
                }
            }
        }
        return bugCount;
    }

    private static boolean isBoundry(int x, int y, int M, int N) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
