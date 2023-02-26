import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int getSumArr(int[][] arr, int i, int j, int x, int y) {
        int sumArr = 0;
        for (int startI = i; startI <= x; startI++) {
            for (int startJ = j; startJ <= y; startJ++)
                sumArr += arr[startI][startJ];
        }
        return sumArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            int i, j, x, y;
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            System.out.println(getSumArr(arr, i-1, j-1, x-1, y-1));
        }
    }
}
