import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int ord = 0;
    private static int[] visited;
    private static ArrayList<Integer>[] graph;

    private static void dfs(int idx) {
        visited[idx] = ++ord;

        for (int node : graph[idx]) {
            if (visited[node] == 0)
                dfs(node);
        }
    }

    private static void displayOrder() {
        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        while (N > 0) {
            graph[N].sort(Comparator.reverseOrder());
            N--;
        }

        dfs(R);
        displayOrder();
    }
}
