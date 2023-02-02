import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static long getMaxLanCable(ArrayList<Long> lanCables, int target) {
        Long max = Collections.max(lanCables), min = 1L, center = (max + min) / 2;
        while (max >= min) {
            long lanCableNum = 0L;
            for (Long lanCable : lanCables) {
                lanCableNum += lanCable / center;
            }
            if (lanCableNum < target) {
                max = center - 1;
                center = (max + min) / 2;
                continue;
            }
            min = center + 1;
            center = (max + min) / 2;
        }
        return center;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Long> lanCables = new ArrayList<>(K);

        while (K > 0) {
            lanCables.add(Long.parseLong(br.readLine()));
            K--;
        }

        System.out.println(getMaxLanCable(lanCables, N));

    }
}
