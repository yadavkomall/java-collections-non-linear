import java.util.*;

public class HasPath {
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
    public static boolean haspath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && haspath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // null ArrayList

        for (int i = 0; i < vertex; i++)// Null to Empty ArrayList
        {
            graph[i] = new ArrayList<Edge>();
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

       boolean pathexist = haspath(graph, 2, 7, new boolean[vertex]);
       System.out.println(pathexist);

    }
}
