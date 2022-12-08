import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int primeTotal = 0;
    private static int primeMin = 10000;

    private static boolean checkPrimeNum(int num){
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static void addPrimeTotal(int num){
        primeTotal += num;
    }

    private static void setPrimeMin(int num){
        if (primeMin > num)
            primeMin = num;
    }

    private static void displayAll(){
        if (primeTotal == 0){
            System.out.println(-1);
            return;
        }
        System.out.println(primeTotal);
        System.out.println(primeMin);
    }

    private static void configure(int M, int N){
        while (M <= N){
            if (checkPrimeNum(M)){
                addPrimeTotal(M);
                setPrimeMin(M);
            }
            M++;
        }
        displayAll();
    }

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        configure(M, N);
    }
}
