import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    // static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    private static void inputConfig() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+2];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int getMaxPrice() {
        for(int i = N; i > 0; i--) {
            int next = i + T[i];

            if(next > N + 1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], P[i] + dp[next]);
            }
        }
        return dp[1];
    }

    private static void outputTotal(int total) throws IOException {
        bw.write(String.valueOf(total));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        inputConfig();
        outputTotal(getMaxPrice());
    }
}
