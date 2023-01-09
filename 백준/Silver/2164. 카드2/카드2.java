import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static Deque<Integer> deque = new ArrayDeque<>();

    private static void setDeque(int N) {
        for (int i = 1; i < N+1; i++) {
            deque.add(i);
        }
    }

    private static int pollDeque() {
        return deque.poll();
    }

    private static void firstToLastDeque() {
        deque.add(pollDeque());
    }

    private static void config() {
        boolean flag = true;
        while (deque.size() > 1) {
            if (flag) {
                pollDeque();
                flag = false;
                continue;
            }
            firstToLastDeque();
            flag = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N < 1)  return;

        setDeque(N);
        config();

        bw.write(String.valueOf(deque.peek()));
        bw.flush();
        bw.close();
    }
}
