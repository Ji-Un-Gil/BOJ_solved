import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    // static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int[][] maps;
    private static int[][] newMaps;
    private static int[][] visited;
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};

    // 1. x, y 입력
    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        newMaps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                newMaps[i][j] = maps[i][j];
            }
        }
    }

    private static int checkAdj(int i, int j) {
        if (maps[i][j] == 0) return 1;
        return 0;
    }

    private static void addAdjVisited(int i, int j) {
        if (maps[i][j] == 0 || visited[i][j] == 1)
            return;
        visited[i][j] = 1;
        for (int idx = 0; idx < dx.length; idx++)
            addAdjVisited(i + dx[idx], j + dy[idx]);
    }

    private static void calculateNext(int i, int j, int zeroes) {
        if (maps[i][j] > zeroes) {
            newMaps[i][j] -= zeroes;
            return;
        }
        newMaps[i][j] = 0;
    }

    private static int resumeYear() {
        int island = 0;
        boolean flag = false;
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                if (maps[i][j] == 0)
                    continue;
                if (visited[i][j] == 0)
                    island += 1;
                int zeroes = 0;
                for (int idx = 0; idx < dx.length; idx++) {
                    int isIsland = checkAdj(i + dx[idx], j + dy[idx]);
                    if (isIsland == 0)
                        addAdjVisited(i + dx[idx], j + dy[idx]);
                    zeroes += isIsland;
                }
                calculateNext(i, j, zeroes);
                if (!flag && maps[i][j] > 0)
                    flag = true;
            }
        }
        if (!flag)
            return -1;
        if (island > 1)
            return 1;
        return 0;
    }

    private static void outputTotal(int total) throws IOException {
        bw.write(String.valueOf(total));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        input();
        int year = 0;
        while (true) {
            visited = new int[N][M];
            int result = resumeYear();
            for (int i = 0; i < N; i++)
                System.arraycopy(newMaps[i], 0, maps[i], 0, M);
            if (result == -1) {
                year = 0;
                break;
            }
            if (result == 1)
                break;
            year++;
        }
        outputTotal(year);
    }
}
