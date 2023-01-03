import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {

    private static int getFives(int num) {
        int fives = 0;

        while (num >= 5){
            fives += (num / 5);
            num /= 5;
        }
        return fives;
    }

    private static int getTwos(int num) {
        int twos = 0;

        while (num >= 2){
            twos += (num / 2);
            num /= 2;
        }
        return twos;
    }

    public static void main(String[] args) throws IOException {
        int m, n, fives, twos;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        fives = getFives(m) - getFives(m - n) - getFives(n);
        twos = getTwos(m) - getTwos(m - n) - getTwos(n);

        System.out.println(min(fives, twos));
    }
}