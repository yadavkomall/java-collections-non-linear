import java.util.*;

public class DetectCycleDirectedGraphs {

    public static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean isCycle(ArrayList<Edge>graph[]){
        boolean vis[]=new boolean [graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleHelper(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean isCycleHelper(ArrayList<Edge>graph[],int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            else if(!vis[e.dest]&& isCycleHelper(graph,e.dest, vis, stack)){
                return true;
            }
        }

        stack[curr]=false;
        return false;
        
    }
    public static void main(String args[]){
int vertex=5;
ArrayList<Edge>graph[] = new ArrayList[vertex];

for(int i=0;i<vertex;i++){
    graph[i]=new ArrayList<>();
}
/* 
graph[0].add(new Edge(0, 1));
graph[2].add(new Edge(2, 1));
graph[2].add(new Edge(2, 3));
graph[3].add(new Edge(3, 4));
graph[4].add(new Edge(4, 2));
*/

graph[0].add(new Edge(0, 1));
graph[0].add(new Edge(0, 2));
graph[2].add(new Edge(2, 3));
graph[1].add(new Edge(1, 3));

System.out.println(isCycle(graph));


    }
}
