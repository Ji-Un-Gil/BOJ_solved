import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    // static StringBuilder sb = new StringBuilder();
    static int x, y;
    static int[][] maps;
    static int[][] visited;
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static ArrayList<ArrayList<int[]>> cases = new ArrayList<>();

    // 1. x, y 입력
    private static void inputXY() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    }

    // 2. maps 채우기
    private static void inputMap() throws IOException {
        visited = new int[x][y];
        maps = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isPossible(int i, int j) {
        return i >= 0 && i < x && j >= 0 && j < y && maps[i][j] != 6;
    }

    private static LinkedList<int[][]> addLocation(int i, int j) {
        int ii, jj;
        LinkedList<int[][]> nextQueue = new LinkedList<>();
        int[][] next;
        if (maps[i][j] == 1) {
            for (int idx = 0; idx < 4; idx++) {
                next = new int[x][y];
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[idx];
                    jj += dy[idx];
                }
                nextQueue.add(next);
            }
        }
        else if (maps[i][j] == 2) {
            for (int idx = 0; idx < 2; idx++) {
                next = new int[x][y];
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[idx];
                    jj += dy[idx];
                }
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[idx+2];
                    jj += dy[idx+2];
                }
                nextQueue.add(next);
            }
        }
        else if (maps[i][j] == 3) {
            for (int idx = 0; idx < 4; idx++) {
                next = new int[x][y];
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[idx];
                    jj += dy[idx];
                }
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[(idx+1)%4];
                    jj += dy[(idx+1)%4];
                }
                nextQueue.add(next);
            }
        }
        else if (maps[i][j] == 4) {
            for (int idx = 0; idx < 4; idx++) {
                next = new int[x][y];
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[idx];
                    jj += dy[idx];
                }
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[(idx+1)%4];
                    jj += dy[(idx+1)%4];
                }
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[(idx+2)%4];
                    jj += dy[(idx+2)%4];
                }
                nextQueue.add(next);
            }
        }
        else {
            next = new int[x][y];
            for (int idx = 0; idx < 4; idx++) {
                ii = i; jj = j;
                while (isPossible(ii, jj)) {
                    next[ii][jj] = 1;
                    ii += dx[idx];
                    jj += dy[idx];
                }
            }
            nextQueue.add(next);
        }
        return nextQueue;
    }

    private static int[][] sumCurAndNext(int[][] a, int[][] b) {
        int[][] result = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (a[i][j] == 1 || b[i][j] == 1)
                    result[i][j] = 1;
            }
        }
        return result;
    }

    private static int getMinBlank(LinkedList<int[][]> queue) {
        int maxLook = 0;
        while (queue.size() > 0) {
            int[][] result = queue.poll();
            int total = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (result[i][j] == 1 || maps[i][j] == 6)
                        total += 1;
                }
            }
            if (maxLook < total)
                maxLook = total;
        }
        return x * y - maxLook;
    }

    private static void checkAllCase() {
        LinkedList<int[][]> queue = new LinkedList<>();
        LinkedList<int[][]> nextQueue = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (maps[i][j] > 0 && maps[i][j] < 6) {
                    LinkedList<int[][]> possibleLocations = addLocation(i, j);
                    if (queue.size() == 0)
                        queue = (LinkedList<int[][]>) possibleLocations.clone();
                    else {
                        while (queue.size() > 0) {
                            int[][] cur = queue.poll();
                            for (int[][] possibleLocation : possibleLocations) {
                                nextQueue.add(sumCurAndNext(cur, possibleLocation));
                            }
                        }
                        queue = (LinkedList<int[][]>) nextQueue.clone();
                    }
                }
            }
        }
        if (queue.size() == 0)
            queue.add(visited);
        outputTotal(getMinBlank(queue));
    }

    // 5. 결과 출력
    private static void outputTotal(int total) {
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        inputXY();
        inputMap();
        checkAllCase();
    }

}
