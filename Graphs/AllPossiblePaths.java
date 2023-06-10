import java.util.*;
public class AllPossiblePaths {
    public static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void printPath(ArrayList<Edge>[]graph,int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printPath(graph, e.dest, dest, path+src);
        }
    }
    public static void main(String args[]){
    int vertex =7;
    ArrayList<Edge>[]graph = new ArrayList[vertex];

    for(int i=0;i<vertex;i++){
        graph[i] =new ArrayList<>();
    }
    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 1));
    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));
    graph[0].add(new Edge(0, 3));

    int src=5;
    int dest =1;

    printPath(graph, src, dest, " ");
    }
}
