import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    // static StringBuilder sb = new StringBuilder();
    static int x, y;
    static int[][] maps;
    static int[][] visited;
    static int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = new int[] {1, 1, 0, -1, -1, -1, 0, 1};

    private static void inputXY() throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
    }

    private static boolean inputMapWithZeroPadding() throws IOException {
        if (x + y == 0)
            return false;

        visited = new int[x+2][y+2];
        maps = new int[x+2][y+2];
        for (int i = 1; i < x+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < y+1; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return true;
    }

    private static boolean isIsland(int i, int j) {
        if (maps[i][j] == 0 || visited[i][j] == 1)
            return false;

        visited[i][j] = 1;
        int idx = 0;
        while (idx < 8) {
            isIsland(i+dx[idx],j+dy[idx]);
            idx += 1;
        }
        return true;
    }

    private static int checkIsland() {
        int total = 0;
        for (int i = 1; i < x+1; i++) {
            for (int j = 1; j < y+1; j++) {
                if (isIsland(i, j)) {
                    total += 1;
                }
            }
        }
        return total;
    }

    private static void outputIslands(int total) {
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        inputXY();
        while (inputMapWithZeroPadding()) {
            outputIslands(checkIsland());
            inputXY();
        }
    }
}
