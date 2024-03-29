import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    // static StringBuilder sb = new StringBuilder();
    static int N;
    static Long first = 4L;
    static Long second = 6L;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    private static Long getTotal() {
        if (N == 1)
            return first;
        if (N == 2)
            return second;
        Long next = first + second;
        first = second;
        second = next;
        N--;
        return getTotal();
    }

    private static void outputTotal(Long total) throws IOException {
        bw.write(String.valueOf(total));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        input();
        outputTotal(getTotal());
    }
}
