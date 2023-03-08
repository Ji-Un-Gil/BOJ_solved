import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int P = 2;

    private static int increaseEraseNum(int eraseNum, int N) {
        eraseNum += P;
        if (eraseNum > N) {
            P++;
            eraseNum = P;
        }
        return eraseNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int eraseNum = P;
        Set<Integer> eraseNumSet = new HashSet<>();

        while (K > eraseNumSet.size() + 1) {
            eraseNumSet.add(eraseNum);
            eraseNum = increaseEraseNum(eraseNum, N);
        }

        int size = eraseNumSet.size();
        eraseNumSet.add(eraseNum);
        while (size == eraseNumSet.size()) {
            eraseNum = increaseEraseNum(eraseNum, N);
            eraseNumSet.add(eraseNum);
        }

        System.out.println(eraseNum);
    }
}
