import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static final ArrayList<Integer> primeNum = new ArrayList<>();

    private static boolean checkPrimeNum(int num){
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static int[] getGoldbach(int n) {
        int small = n / 2, big = n / 2;
        boolean flag = false;
        if (n % 2 != 0)
            big++;

        while (!(primeNum.contains(small) && primeNum.contains(big))) {
            small--;
            big++;
        }

        return new int[]{small, big};
    }

    public static void main(String[] args) throws IOException {
        for (int i = 2; i < 9974; i++) {
            if (checkPrimeNum(i))
                primeNum.add(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] result = getGoldbach(n);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
