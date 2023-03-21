import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> temperature = new ArrayList<>();

    private static void setTemperature(BufferedReader br, int N) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            temperature.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static int setAccTemperature(int N, int K){
        int max = -10000000, total = 0;
        for (int i = 0; i < K; i++) {
            total += temperature.get(i);
        }
        max = compareEach(max, total);

        for (int i = K; i < N; i++) {
            total += temperature.get(i) - temperature.get(i - K);
            max = compareEach(max, total);
        }
        return max;
    }

    private static int compareEach(int max, int total){
        if (total > max){
            return total;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] condition = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        setTemperature(br, condition[0]);
        System.out.println(setAccTemperature(condition[0], condition[1]));
    }
}
