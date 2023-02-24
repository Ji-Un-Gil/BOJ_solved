import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int countChar(String str, char ch) {
        return (int) str.chars().filter(c -> c == ch).count();
    }

    private static String changeNineToSix(String N) {
        return N.replace("9", "6");
    }

    private static int getNeedSets(String N) {
        int num = 0, sets = 0;
        while (num < 9) {
            int compareSet = countChar(N, Character.forDigit(num, 10));
            if (num == 6)
                compareSet = (compareSet / 2) + (compareSet % 2);
            if (sets < compareSet)
                sets = compareSet;
            num++;
        }
        return sets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = changeNineToSix(br.readLine());
        System.out.println(getNeedSets(N));
    }
}
