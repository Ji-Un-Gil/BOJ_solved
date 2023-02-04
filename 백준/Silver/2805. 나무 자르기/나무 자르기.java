import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static long getMaxHeight(ArrayList<Long> trees, Long M) {
        Long max = Collections.max(trees), min = 0L, center = (max + min) / 2;
        while (max >= min) {
            long cutTreesTotal = 0L;
            for (Long tree : trees) {
                if (tree < center)
                    continue;
                cutTreesTotal += tree - center;
            }
            if (cutTreesTotal < M) {
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
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        ArrayList<Long> trees = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine());

        while (N > 0) {
            trees.add(Long.parseLong(st.nextToken()));
            N--;
        }

        System.out.println(getMaxHeight(trees, M));
    }
}
