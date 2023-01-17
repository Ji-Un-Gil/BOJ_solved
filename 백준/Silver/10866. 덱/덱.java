import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Main {

    private static Deque<Integer> queue = new ArrayDeque<>();

    private static int orderQueue(String input) {
        Integer output;

        switch (input) {
            case "pop_front":
                output = queue.pollFirst();
                if (output == null)
                    return -1;
                return output;
            case "pop_back":
                output = queue.pollLast();
                if (output == null)
                    return -1;
                return output;
            case "size":
                return queue.size();
            case "empty":
                if (queue.isEmpty())
                    return 1;
                return 0;
            case "front":
                output = queue.peekFirst();
                if (output == null)
                    return -1;
                return output;
            case "back":
                output = queue.peekLast();
                if (output == null)
                    return -1;
                return output;
            default:
                if (Objects.equals(input.split(" ")[0], "push_front")) {
                    queue.addFirst(Integer.parseInt(input.split(" ")[1]));
                    return -2;
                }
                queue.addLast(Integer.parseInt(input.split(" ")[1]));
                return -2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int output;

        int N = Integer.parseInt(br.readLine());
        while (N > 0) {
            output = orderQueue(br.readLine());
            if (output != -2)
                bw.write(output + "\n");
            N--;
        }

        bw.flush();
        bw.close();
    }
}

