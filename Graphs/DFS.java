import java.util.ArrayList;

public class DFS {

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

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.println(curr);
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String args[]) {

        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // null ArrayList

        for (int i = 0; i < vertex; i++)// Null to Empty ArrayList
        {
            graph[i] = new ArrayList<>();
        }
         /*
         0--1--3
         \    / \
          2--4---5--6 
         */

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 2));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 5));

        
        dfs(graph, 0, new boolean[vertex]);

    }
}
