import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    // static StringBuilder sb = new StringBuilder();
    private static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    private static boolean[] visited;
    private static int total = 0;

    private static void input() throws IOException {
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++)
            nodes.add(new ArrayList<>());
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.get(x).add(y);
            nodes.get(y).add(x);
        }
    }

    private static void dfs(int node, int depth) {
        visited[node] = true;

        for (int childNode : nodes.get(node)) {
            if (!visited[childNode])
                dfs(childNode, depth+1);
        }

        if (nodes.get(node).size() == 1 && node != 1)
            total += depth;
    }

    private static void outputTotal() throws IOException {
        if (total % 2 == 1)
            bw.write("Yes");
        else
            bw.write("No");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(1, 0);
        outputTotal();
    }
}
