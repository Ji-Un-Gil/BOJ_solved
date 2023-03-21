import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final int DIVISOR = 100000;
    private static ArrayList<Integer> sequenceD = new ArrayList<>();

    private static void addSequenceD(int num, int P) {
        int nextD = 0, divisor = DIVISOR;
        while (num > 0) {
            int partNum = num / divisor;
            nextD += (int) Math.pow(partNum, P);
            num -= partNum * divisor;
            divisor /= 10;
        }
        sequenceD.add(nextD);
    }

    private static int checkRepeatPoint() {
        int lastD = sequenceD.get(sequenceD.size()-1);
        for (int idx = 0; idx < sequenceD.size() - 1; idx++) {
            if (sequenceD.get(idx).equals(lastD))
                return idx;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        sequenceD.add(A);
        addSequenceD(A, P);
        while (true) {
            addSequenceD(sequenceD.get(sequenceD.size()-1), P);
            int result = checkRepeatPoint();
            if (result > -1) {
                bw.write(String.valueOf(result));
                bw.flush();
                break;
            }
        }

    }
}
