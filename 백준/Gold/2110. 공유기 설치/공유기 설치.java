import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static long getMinRange(ArrayList<Long> houses) {
        ArrayList<Long> diffHouses = new ArrayList<>(houses.size() - 1);
        for (int i = 1; i < houses.size(); i++) {
            diffHouses.add(houses.get(i) - houses.get(i - 1));
        }
        return Collections.min(diffHouses);
    }

    private static long getMaxRange(ArrayList<Long> houses, int C) {
        long max = (houses.get(houses.size() - 1) - houses.get(0)) / (C - 1),
                min = getMinRange(houses), center = (max + min) / 2;

        while (max >= min) {
            long targetC = houses.get(0) + center;
            int totalCs = 0;
            for (Long house : houses) {
                if (house >= targetC) {
                    totalCs++;
                    targetC = house + center;
                }
            }
            if (totalCs < C - 1) {
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
        int C = Integer.parseInt(st.nextToken());
        ArrayList<Long> houses = new ArrayList<>(N);

        while (N > 0) {
            houses.add(Long.parseLong(br.readLine()));
            N--;
        }
        Collections.sort(houses);

        System.out.println(getMaxRange(houses, C));
    }
}
