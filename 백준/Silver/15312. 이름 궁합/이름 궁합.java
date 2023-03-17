import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int[] alphabet = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    private static final int ASCIIALP = 65;
    private static int[] result;

    private static void setAlphabetToNum(String A, String B) {
        result = new int[A.length() + B.length()];
        int a = 0, b = 0;
        while (b < B.length()) {
            if ((a + b) % 2 == 0) {
                result[2 * a] = alphabet[A.charAt(a) - ASCIIALP];
                a++;
                continue;
            }
            result[2 * b + 1] = alphabet[B.charAt(b) - ASCIIALP];
            b++;
        }
    }

    private static void getTwoDigitResult() {
        int lastIdx = result.length;
        while (lastIdx > 2) {
            for (int i = 0; i + 1 < lastIdx; i++) {
                int bout = result[i] + result[i + 1];
                if (bout >= 10)
                    result[i] = bout - 10;
                else
                    result[i] = bout;
            }
            lastIdx--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        setAlphabetToNum(A, B);
        getTwoDigitResult();
        System.out.println(String.valueOf(result[0]) + result[1]);
    }
}
