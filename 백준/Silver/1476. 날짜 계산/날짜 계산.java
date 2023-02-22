import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_E = 15, MAX_S = 28, MAX_M = 19;

    private static int getFastestYear(int E, int S, int M) {
        int target = 1;
        while (target % MAX_E != E % MAX_E || target % MAX_S != S % MAX_S || target % MAX_M != M % MAX_M)
            target++;
        return target;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(getFastestYear(E, S, M));
    }
}
