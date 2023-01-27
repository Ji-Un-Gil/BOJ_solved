import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Long> distance = new ArrayList<>();
    private static ArrayList<Long> price = new ArrayList<>();

    private static long getMinPriceTotal() {
        long minPriceTotal = 0;
        long maxPrice = (long) Math.pow(10, 10) + 1;
        for (int i = 0; i < price.size() - 1; i++) {
            if (price.get(i) < maxPrice)
                maxPrice = price.get(i);
            minPriceTotal += maxPrice * distance.get(i);
        }
        return minPriceTotal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer distanceList = new StringTokenizer(br.readLine());
        StringTokenizer priceList = new StringTokenizer(br.readLine());
        while (N-1 > 0) {
            distance.add(Long.parseLong(distanceList.nextToken()));
            price.add(Long.parseLong(priceList.nextToken()));
            N--;
        }
        price.add(Long.parseLong(priceList.nextToken()));

        System.out.println(getMinPriceTotal());
    }
}
