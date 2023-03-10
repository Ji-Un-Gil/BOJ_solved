import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {


    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static HashSet<Integer> hashSet = new HashSet<>();
    private static final HashSet<Integer> allHashSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

    private static void setOperation(StringTokenizer st) throws IOException {
        switch (st.nextToken()) {
            case "add" :
                hashSet.add(Integer.parseInt(st.nextToken()));
                break;
            case "remove" :
                hashSet.remove(Integer.parseInt(st.nextToken()));
                break;
            case "check" :
                if (hashSet.contains(Integer.parseInt(st.nextToken()))) {
                    bw.write("1\n");
                    break;
                }
                bw.write("0\n");
                break;
            case "toggle" :
                int x = Integer.parseInt(st.nextToken());
                if (!hashSet.remove(x))
                    hashSet.add(x);
                break;
            case "all" :
                hashSet = allHashSet;
                break;
            case "empty":
                hashSet.clear();
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        while (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            setOperation(st);
            M--;
        }
        bw.flush();
    }
}
