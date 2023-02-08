import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static int getKNum(int N, int k) {
        int max = k, min = 1;

        while (max > min) {
            int center = (max + min) / 2, numIdx = 0;
            for (int i = 1; i <= N; i++)
                numIdx += Math.min(center / i, N);
            if (numIdx >= k) {
                max = center;
                continue;
            }
            min = center + 1;
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        System.out.println(getKNum(N, k));
    }
}
