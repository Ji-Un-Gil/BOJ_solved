import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String[] input;
    // static StringBuilder sb = new StringBuilder();
    static int x, y;
    static int[][] board;
    static ArrayDeque<int[][]> coin = new ArrayDeque<>();
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};

    // 1. 입력값 저장
    private static void inputConfig() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int[][] firstLocation = new int[2][2];
        board = new int[x][y];
        int idx = 0;
        for (int i = 0; i < x; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < y; j++) {
                if (Objects.equals(input[j], "o")) {
                    firstLocation[idx][0] = i;
                    firstLocation[idx][1] = j;
                    idx++;
                } else if (Objects.equals(input[j], "#"))
                    board[i][j] = 1;
            }
        }
        coin.add(firstLocation);
    }

    private static int checkOutCoin(int firstX, int firstY, int secondX, int secondY) {
        int out = 0;
        if (firstX < 0 || firstX >= board.length || firstY < 0 || firstY >= board[0].length)
            out++;
        if (secondX < 0 || secondX >= board.length || secondY < 0 || secondY >= board[0].length)
            out++;
        return out;
    }

    private static boolean isValidLocation(int x, int y) {
        return board[x][y] != 1;
    }

    private static int bfs() {
        ArrayDeque<int[][]> nextCoin = new ArrayDeque<>();
        int turn = 1;
        while (turn < 11) {
            if (coin.isEmpty())
                return -1;
            while (!coin.isEmpty()) {
                int[][] coinLocation = coin.pop();
                for (int idx = 0; idx < dx.length; idx++) {
                    int firstX = coinLocation[0][0] + dx[idx];
                    int firstY = coinLocation[0][1] + dy[idx];
                    int secondX = coinLocation[1][0] + dx[idx];
                    int secondY = coinLocation[1][1] + dy[idx];
                    int result = checkOutCoin(firstX, firstY, secondX, secondY);
                    if (result == 1)
                        return turn;
                    if (result == 0) {
                        if (!isValidLocation(firstX, firstY)) {
                            firstX -= dx[idx];
                            firstY -= dy[idx];
                        }
                        if (!isValidLocation(secondX, secondY)) {
                            secondX -= dx[idx];
                            secondY -= dy[idx];
                        }
                        nextCoin.add(new int[][]{{firstX, firstY}, {secondX, secondY}});
                    }
                }
            }
            coin.addAll(nextCoin);
            nextCoin = new ArrayDeque<>();
            turn++;
        }
        return -1;
    }

    // 4. 출력
    private static void outputTotal(int total) throws IOException {
        bw.write(String.valueOf(total));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        inputConfig();
        outputTotal(bfs());
    }
}
