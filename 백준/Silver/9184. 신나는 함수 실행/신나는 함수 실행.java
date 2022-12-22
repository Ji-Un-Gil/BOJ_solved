import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] wResult = new int[20][20][20];

    private static int config(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        if (a > 20 || b > 20 || c > 20)
            return config(20, 20, 20);

        if (wResult[a-1][b-1][c-1] != 0)
            return wResult[a-1][b-1][c-1];

        if (a < b && b < c){
            wResult[a-1][b-1][c-1] = config(a, b, c-1) + config(a, b-1, c-1) - config(a, b-1, c);
            return wResult[a-1][b-1][c-1];
        }
        wResult[a-1][b-1][c-1] = config(a-1, b, c) + config(a-1, b-1, c)
                + config(a-1, b, c-1) - config(a-1, b-1, c-1);
        return wResult[a-1][b-1][c-1];
    }

    public static void main(String[] args) throws IOException {
        int[] abc = new int[3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            abc[i] = Integer.parseInt(st.nextToken());
        }

        while (abc[0] != -1 || abc[1] != -1 || abc[2] != -1){
            System.out.printf("w(%d, %d, %d) = %d\n", abc[0], abc[1], abc[2], config(abc[0], abc[1], abc[2]));
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                abc[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}