import java.util.*;
public class ConnectedComponentsDFS {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void dfs(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            dfsHelper(graph, i, vis);
        }
    }

    public static void dfsHelper(ArrayList<Edge>[] graph,int curr,boolean vis[]){
        System.out.println(curr);
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsHelper(graph, e.dest, vis);
            }
        }
    }

    public static void main(String args[]){
        int vertex =5;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for(int i=0;i<vertex;i++){
            graph[i]=new ArrayList<Edge>();
        }
        /*
            0--1      3
            |         |
            2         4  
        */

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(3, 4, 0));

        dfs(graph);
    }
}
