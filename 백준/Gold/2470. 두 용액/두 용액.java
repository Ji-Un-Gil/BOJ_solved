import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] liquid;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        liquid = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            liquid[i] = Integer.parseInt(st.nextToken());
    }

    private static void sort() {
        Arrays.sort(liquid);
    }

    private static Pair findLessAbstract() {
        long lessAbs = Long.MAX_VALUE;
        int lessLeft = 0, lessRight = 0;
        int left = 0, right = N-1;
        long abs;

        while (left < right) {
            abs = liquid[right] + liquid[left];
            if (Math.abs(abs) < lessAbs) {
                lessAbs = Math.abs(abs);
                lessLeft = liquid[left];
                lessRight = liquid[right];
            }
            if (abs > 0) {
                right -= 1;
            } else if (abs < 0) {
                left += 1;
            } else return new Pair(lessLeft, lessRight);
        }

        return new Pair(lessLeft, lessRight);
    }

    private static void outputTotal(Pair result) throws IOException {
        bw.write(sb.append(result.getStart()).append(" ").append(result.getEnd()).toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        outputTotal(findLessAbstract());
    }
}

class Pair implements Comparable<Pair> {

    private int start;
    private int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Pair o) {
        if (start == o.start)
            return Integer.compare(end, o.end);
        return Integer.compare(start, o.start);
    }
}