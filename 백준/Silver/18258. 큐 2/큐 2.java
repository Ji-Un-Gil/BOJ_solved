import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static Deque<Integer> queue = new ArrayDeque<>();

    private static int orderQueue(String input) {
        Integer output;

        switch (input) {
            case "pop":
                output = queue.poll();
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
                output = queue.peek();
                if (output == null)
                    return -1;
                return output;
            case "back":
                output = queue.peekLast();
                if (output == null)
                    return -1;
                return output;
            default:
                queue.add(Integer.parseInt(input.split(" ")[1]));
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