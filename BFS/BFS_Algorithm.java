package BFS; /**
 * BFS(Breadth-First-Search) using color (don`t using visit Array)
 **/
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Algorithm {
     static char[] vertex = {'r','s','t','u','v','w','x','y'};
     static int size= vertex.length;
     static int[][] map = new int[size][size];
    public static void main(String[] args) {
        addEdge('r','s');
        addEdge('s','w');
        addEdge('r','v');
        addEdge('w','t');
        addEdge('w','x');
        addEdge('t','x');
        addEdge('x','y');
        addEdge('x','u');
        addEdge('t','u');
        addEdge('u','y');
        Node rootNode = bfs(map,'s');
        while(rootNode.parent != null){
            System.out.println("Current Vertex: "+rootNode.vertex
                    +",Current Vertex Cost: "+rootNode.cost
                    +",Parent Vertex: " +rootNode.parent.vertex);
            rootNode = rootNode.parent;
        }
    }
    static Node bfs(int[][] map, char start){
        List<Node> list = new LinkedList<>();
        for(int i=0;i<size;i++)
            list.add(new Node(vertex[i],0,"WHITE",null));
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start,0,"GRAY",null));    //Set start Vertex

        Node tmpNode = null;
        while(!queue.isEmpty()){
            tmpNode = queue.poll();
            if(list.get(index(tmpNode.vertex)).color.equals("BLACK"))
                continue;
            for(int i=0;i<size;i++){
                if(list.get(i).color.equals("WHITE") && map[index(tmpNode.vertex)][i] == 1){
                    queue.add(new Node(vertex[i],tmpNode.cost+1,"GRAY",tmpNode));
                    list.set(i,new Node(vertex[i],tmpNode.cost+1,"GRAY",tmpNode));
                }
            }
            tmpNode.color = "BLACK";
            list.set(index(tmpNode.vertex),tmpNode);
        }
        return tmpNode;
    }
    static private void addEdge(char c1, char c2){
        map[index(c1)][index(c2)] = map[index(c2)][index(c1)] =1;
    }
    static private int index(char c){
        for(int i=0;i<vertex.length;i++)
            if(c == vertex[i])
                return i;
        return -1;
    }
    static class Node{
        char vertex;
        int cost;
        String color;
        Node parent;
        Node(char vertex, int cost,String color,Node parent){
            this.vertex = vertex;
            this.cost = cost;
            this.color = color;
            this.parent = parent;
        }
    }
}
