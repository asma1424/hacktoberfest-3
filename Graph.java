import java.util.*;

public class Graph {

    public static class Edge {
        int ver1;
        int ver2;
        int wgt;
        int lvl;

        Edge(int v1, int v2, int wt,int l) {
            this.ver1 = v1;
            this.ver2 = v2;
            this.wgt = wt;
            this.lvl = l;
        }

        Edge() {
            this.ver1 = 0;
            this.ver2 = 0;
            this.wgt = 1;
            this.lvl = 0;
        }
    }

    public static class vertix implements Comparable<vertix> {
        int ver1;
        int wgt;

        vertix(int v, int w) {
            this.ver1 = v;
            this.wgt = w;
        }

        public int compareTo(vertix cmp) {
            return this.wgt - cmp.wgt;
        }

    }

    public static ArrayList<Integer> BFS(ArrayList<ArrayList<Edge>> adj_list, int e) {
        ArrayList<Integer> bfs_lst = new ArrayList<>();
        boolean[] visited = new boolean[adj_list.size()];
        Queue<Integer> Q = new LinkedList<Integer>();

        Q.add(e);

        while (Q.size() > 0) {
            int temp = Q.remove();

            if (visited[temp] == true)
                continue;

            bfs_lst.add(temp);
            visited[temp] = true;

            for (int i = 0; i < adj_list.get(temp).size(); i++) {
                int temp2 = adj_list.get(temp).get(i).ver2;

                if (visited[temp2] == false)
                    Q.add(temp2);
            }
        }
        return bfs_lst;
    }

    public static int BFS_shortest(ArrayList<ArrayList<Edge>> adj_list, int e,int d) {
        
        boolean[] visited = new boolean[adj_list.size()];
        Queue<Integer> Q = new LinkedList<Integer>();
        int dis[] = new int[adj_list.size()];        

        Q.add(e);
        visited[e] = true;

        while (Q.size() > 0) {
            int temp = Q.remove();
                    
            for (int i = 0; i < adj_list.get(temp).size(); i++) {
                int temp2 = adj_list.get(temp).get(i).ver2;
                
                if (visited[temp2] == false){
                    dis[adj_list.get(temp).get(i).ver2] = dis[temp] + 1;
                    Q.add(temp2);
                    visited[temp2] = true;
                }
                else
                    continue;
            }
        }
        return dis[d];
    }

    public static void DFS(ArrayList<ArrayList<Edge>> adj_list, int v, boolean[] visited, ArrayList<Integer> dfs_lst) {

        if (visited[v] == true) {
            return;
        }

        visited[v] = true;
        dfs_lst.add(v);
        for (int i = 0; i < adj_list.get(v).size(); i++) {
            int temp = adj_list.get(v).get(i).ver2;
            if (visited[temp] == false) {
                DFS(adj_list, temp, visited, dfs_lst);
            }
        }
    }

    public static int[] Dijkstra_ShortestWeighted(ArrayList<ArrayList<Edge>> adj_list, int e, int d, int[] visited) {
        PriorityQueue<vertix> Q = new PriorityQueue<>();

        vertix v = new vertix(e, 0);

        Q.add(v);

        while (Q.size() > 0) {
            vertix temp = Q.remove();

            if(temp.ver1 == 3)
                return visited;
            
            if (visited[temp.ver1] != -1)
                continue;

            visited[temp.ver1] = temp.wgt;

            for (int i = 0; i < adj_list.get(temp.ver1).size(); i++) {
                Edge temp2 = adj_list.get(temp.ver1).get(i);

                if (visited[temp2.ver2] == -1) {
                    vertix nv = new vertix(temp2.ver2, temp.wgt + temp2.wgt);
                    Q.add(nv);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) throws Exception {

        int v = 7, e = 8;

        int vrr[] = { 1, 1, 2, 3, 4, 5, 6, 5 };
        int err[] = { 2, 4, 3, 4, 5, 6, 7, 7 };
        int wgt[] = { 1, 1, 1, 1, 1, 1, 1, 1 };

        ArrayList<ArrayList<Edge>> adj_list = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj_list.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            Edge e1 = new Edge(vrr[i] - 1, err[i] - 1, wgt[i],0);
            Edge e2 = new Edge(err[i] - 1, vrr[i] - 1, wgt[i],0);

            // Both for un-directed graph
            // Fisrt for directed graph
            adj_list.get(vrr[i] - 1).add(e1);
            adj_list.get(err[i] - 1).add(e2);
        }

        boolean visited[] = new boolean[adj_list.size()];

        ArrayList<Integer> lst = BFS(adj_list, 0);

        ArrayList<Integer> lst2 = new ArrayList<>();
        DFS(adj_list, 0, visited, lst2);

        for (int i = 0; i < lst.size(); i++)
            System.out.print(lst.get(i) + 1 + " ");

        System.out.println();

        for (int i = 0; i < lst2.size(); i++)
            System.out.print(lst2.get(i) + 1 + " ");

        System.out.println();

        int[] visited2 = new int[v];
        Arrays.fill(visited2, -1);

        int[] lst3 = Dijkstra_ShortestWeighted(adj_list, 0,3, visited2);

        for (int i = 0; i < v; i++)
            System.out.print(lst3[i] + " ");

        System.out.println();

        System.out.println(BFS_shortest(adj_list, 0, 6));
    


    }

}
