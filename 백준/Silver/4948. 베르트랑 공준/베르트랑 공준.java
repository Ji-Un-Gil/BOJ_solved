import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean checkPrimeNum(int num){
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static int getBertrand(int n){
        int doubleN = 2 * n;
        int primeTotal = 0;
        n++;
        while (n <= doubleN){
            if (checkPrimeNum(n)){
                primeTotal++;
            }
            n++;
        }
        return primeTotal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n != 0){
            System.out.println(getBertrand(n));
            n = Integer.parseInt(br.readLine());
        }
    }
}