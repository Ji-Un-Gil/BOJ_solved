import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    private static void config(int x) {
        if (x > 0) {
            priorityQueue.add(x);
            return;
        }
        Integer pollNum = priorityQueue.poll();
        if (pollNum == null) {
            System.out.println(0);
            return;
        }
        System.out.println(pollNum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            config(Integer.parseInt(br.readLine()));
            N--;
        }
    }
}
