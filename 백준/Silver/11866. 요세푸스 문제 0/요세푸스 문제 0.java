import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static Queue<Integer> queue;
    private static Queue<Integer> result;

    private static void setQueue(int N) {
        result = new ArrayDeque<>(N);
        queue = new ArrayDeque<>(N);
        for (int i = 1; i < N+1; i++) {
            queue.add(i);
        }
    }

    private static void getQueue(int K) {
        int eraseNum = 1;
        while (!queue.isEmpty()) {
            while (eraseNum < K) {
                queue.add(queue.poll());
                eraseNum++;
            }
            addResult(queue.poll());
            eraseNum = 1;
        }
    }

    private static void addResult(int queueNum) {
        result.add(queueNum);
    }

    private static void displayResult() {
        int idx = 0, size = result.size() - 1;
        System.out.print("<");
        while (idx < size) {
            System.out.printf("%d, ", result.poll());
            idx++;
        }
        System.out.printf("%d>", result.poll());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        setQueue(N);
        getQueue(K);
        displayResult();
    }
}
