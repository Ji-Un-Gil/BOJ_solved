import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        while (N > 0) {
            deque.push(N);
            N--;
        }
        while (deque.size() > 1) {
            System.out.print(deque.poll() + " ");
            deque.addLast(deque.poll());
        }
        System.out.print(deque.poll());
    }
}
