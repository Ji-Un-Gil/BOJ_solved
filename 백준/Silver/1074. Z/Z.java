import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long division(int N, int r, int c, long visited) {
        if (r < 2 && c < 2) {
            if (r == 0 && c == 0)
                return visited;
            else if (r == 0 && c == 1)
                return visited + 1;
            else if (r == 1 && c == 0)
                return visited + 2;
            return visited + 3;
        }

        int center = 1 << (N - 1);
        if (r < center) {
            if (c < center)
                return division(N - 1, r, c, visited);
            return division(N - 1, r, c - center, visited + (1L << (2 * N)) / 4);
        }
        if (c < center)
            return division(N - 1, r - center, c, visited + (1L << (2 * N)) / 2);
        return division(N - 1, r - center, c - center, visited + (1L << (2 * N)) * 3 / 4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(division(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0L));
    }
}
