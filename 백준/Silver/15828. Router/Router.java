import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static Queue<Integer> queue = new ArrayDeque<>();
    private static int N;

    private static void setQueue(int input) {
        if (input == 0) {
            queue.poll();
            return;
        }

        if (queue.size() == N)
            return;

        queue.add(input);
    }

    private static void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("empty");
            return;
        }
        while (!queue.isEmpty()) {
            System.out.printf("%d ", queue.poll());
        }
    }

    public static void main(String[] args) throws IOException {
        int input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = Integer.parseInt(br.readLine());
        while (input != -1) {
            setQueue(input);
            input = Integer.parseInt(br.readLine());
        }

        displayQueue();
    }
}
