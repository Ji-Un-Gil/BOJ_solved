import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Pair> sessionTime = new ArrayList<>();

    private static int getMaxSessions() {
        int maxSessions = 0;
        Pair curSession = new Pair(sessionTime.get(0).getStart(), sessionTime.get(0).getEnd());
        for (Pair pair : sessionTime.subList(1,sessionTime.size())) {
            if (pair.getStart() >= curSession.getEnd()) {
                curSession = new Pair(pair.getStart(), pair.getEnd());
                maxSessions++;
                continue;
            }
            if (pair.getStart() >= curSession.getStart() && pair.getEnd() <= curSession.getEnd())
                curSession = new Pair(pair.getStart(), pair.getEnd());
        }
        return maxSessions + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sessionTime.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            N--;
        }
        Collections.sort(sessionTime);
        System.out.println(getMaxSessions());
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