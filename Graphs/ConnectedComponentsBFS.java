import java.util.*;

public class ConnectedComponentsBFS {

    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsHelper(graph, vis);
               
            }
        }
    }
    public static void bfsHelper(ArrayList<Edge>[] graph,boolean vis[]){
        Queue<Integer>q = new LinkedList<>();
       
        q.add(0);

        while(! q.isEmpty()){
            int curr = q.remove();
            if(! vis[curr]){
                System.out.println(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String args[]){

        int vertex =7;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        for(int i=0;i<vertex;i++){
            graph[i]=new ArrayList<>();
        }
        /*
            0--1      3
            |         |
            2         4  
        */

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(3, 4, 0));

        bfs(graph);
    }
}
