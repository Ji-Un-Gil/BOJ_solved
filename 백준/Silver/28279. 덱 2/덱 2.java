import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (command.equals("2")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (command.equals("3")) {
                bw.write(deque.isEmpty() ? "-1\n" : deque.pollFirst().toString() + "\n");
            } else if (command.equals("4")) {
                bw.write(deque.isEmpty() ? "-1\n" : deque.pollLast().toString() + "\n");
            } else if (command.equals("5")) {
                bw.write(deque.size() + "\n");
            } else if (command.equals("6")) {
                bw.write(deque.isEmpty() ? "1\n" : "0\n");
            } else if (command.equals("7")) {
                bw.write(deque.isEmpty() ? "-1\n" : deque.getFirst().toString() + "\n");
            } else if (command.equals("8")) {
                bw.write(deque.isEmpty() ? "-1\n" : deque.getLast().toString() + "\n");
            }
        }
        bw.flush();
    }
}