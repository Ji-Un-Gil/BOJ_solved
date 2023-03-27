import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int[][] fillMatrix(int[][] matrix, int row, int column) throws IOException {
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        return matrix;
    }

    private static void multipleMatrix(int[][] A, int[][] B) throws IOException {
        // int[][] result = new int[A.length][B[0].length];
        int sum;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                sum = 0;
                for (int k = 0; k < A[0].length; k++)
                    sum += A[i][k] * B[k][j];
                bw.write(sum + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        // return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        A = fillMatrix(A, N, M);

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];
        B = fillMatrix(B, M, K);

        multipleMatrix(A, B);
    }
}
