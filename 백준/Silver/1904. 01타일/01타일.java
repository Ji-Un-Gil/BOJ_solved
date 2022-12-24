import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long config(int N){
        long first = 1L, second = 2L, target = 0L;
        if (N == 1) return first;
        if (N == 2) return second;
        while (N > 2){
            target = (first + second) % 15746;
            first = second;
            second = target;
            N--;
        }
        return target;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(config(Integer.parseInt(br.readLine())));
    }
}
