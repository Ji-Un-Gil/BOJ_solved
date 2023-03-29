import java.io.*;
import java.util.Objects;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static int getValue(String[][] array) {
        int value = 0;
        for (String[] strings : array) {
            String recentString = "X";
            boolean isCount = false;
            for (String string : strings) {
                if (Objects.equals(string, ".")) {
                    if (Objects.equals(recentString, ".") && !isCount) {
                        value++;
                        isCount = true;
                    }
                }
                else
                    isCount = false;
                recentString = string;
            }
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[][] rowRoom = new String[N][N];
        String[][] columnRoom = new String[N][N];
        for (int i = 0; i < N; i++) {
            String place = br.readLine();
            for (int j = 0; j < N; j++) {
                rowRoom[i][j] = String.valueOf(place.charAt(j));
                columnRoom[j][i] = String.valueOf(place.charAt(j));
            }
        }
        int row = getValue(rowRoom), column = getValue(columnRoom);
        sb.append(row).append(" ").append(column);
        bw.write(sb.toString());
        bw.flush();
    }
}