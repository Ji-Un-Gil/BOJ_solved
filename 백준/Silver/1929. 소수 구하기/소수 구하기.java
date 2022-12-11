import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean checkPrimeNum(int num){
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static void displayPrimeNum(int num){
        System.out.println(num);
    }

    private static void configure(int M, int N){
        while (M <= N){
            if (checkPrimeNum(M)){
                displayPrimeNum(M);
            }
            M++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        configure(M, N);
    }
}
