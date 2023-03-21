import java.io.*;

public class Main {

    private static String checkNameOrder(String oldName, String nextName) {
        int isIncrease = nextName.compareTo(oldName);
        if (isIncrease > 0)
            return "INCREASING";
        return "DECREASING";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String result = "";
        String oldName = br.readLine();
        while (N > 1) {
            String nextName = br.readLine();
            if (result.equals(""))
                result = checkNameOrder(oldName, nextName);
            if (!checkNameOrder(oldName, nextName).equals(result)) {
                bw.write("NEITHER\n");
                bw.flush();
                return;
            }
            oldName = nextName;
            N--;
        }
        bw.write(result);
        bw.flush();
    }
}
