import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static boolean isFound(long[] arr, long num) {
        return Arrays.binarySearch(arr, num) >= 0;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M > 0) {
            M--;
            if (isFound(A, Long.parseLong(st.nextToken()))) {
                System.out.println(1);
                continue;
            }
            System.out.println(0);
        }
    }
}
