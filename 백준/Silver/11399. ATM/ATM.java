import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer> arrayList = new ArrayList<>();

    private static int getTotalTime() {
        int totalTime = 0, recentTime = 0;
        for (Integer value : arrayList) {
            totalTime += recentTime;
            recentTime += value;
            totalTime += value;
        }
        return totalTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N > 0) {
            arrayList.add(Integer.parseInt(st.nextToken()));
            N--;
        }
        arrayList.sort(Comparator.naturalOrder());
        System.out.println(getTotalTime());
    }
}
