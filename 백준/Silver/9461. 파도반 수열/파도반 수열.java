import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final long[] waveSeqStart = {1, 1, 1, 2, 2, 3, 4, 5};
    private static long[] waveSeqTotal = new long[100];

    private static long config(int N){
        if (waveSeqTotal[N-1] != 0){
            return waveSeqTotal[N-1];
        }
        waveSeqTotal[N-1] = config(N-1) + config(N-5);
        return waveSeqTotal[N-1];
    }

    public static void main(String[] args) throws IOException {
        System.arraycopy(waveSeqStart, 0, waveSeqTotal, 0, waveSeqStart.length);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0){
            System.out.println(config(Integer.parseInt(br.readLine())));
            T--;
        }
    }
}
