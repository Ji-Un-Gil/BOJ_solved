import java.io.*;

public class Main {

    private static final int DIGITCHANGEPOINT = 9;

    private static int getTotalDigit(int N) {
        int totalDigit = 0, digit = 1, multiplier = DIGITCHANGEPOINT, digitChange = DIGITCHANGEPOINT;
        while (N > digitChange) {
            totalDigit += digit * multiplier;
            multiplier = 9 * (int) Math.pow(10, digit);
            digitChange += multiplier;
            digit++;
        }
        totalDigit += digit * (N - (int) Math.pow(10, digit - 1) + 1);
        return totalDigit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getTotalDigit(N)));
        bw.flush();
    }
}
