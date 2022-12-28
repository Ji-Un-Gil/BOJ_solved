import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int K, num;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        while (K > 0){
            num = Integer.parseInt(br.readLine());
            if (num == 0)
                stack.pop();
            else
                stack.push(num);
            K--;
        }

        System.out.println(stack.stream().mapToInt(Integer::intValue).sum());
    }
}