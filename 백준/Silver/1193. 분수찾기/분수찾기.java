import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void displayXthFraction(int X) {
        int lineNum = 1;
        while (X > lineNum) {
            X -= lineNum;
            lineNum++;
        }
        if (lineNum % 2 == 0) {
            System.out.printf("%d/%d", X, lineNum - X + 1);
            return;
        }
        System.out.printf("%d/%d", lineNum - X + 1, X);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        displayXthFraction(X);
    }
}
