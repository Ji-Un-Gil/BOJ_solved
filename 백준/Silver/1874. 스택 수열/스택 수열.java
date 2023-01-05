import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    private static Stack<Integer> stack = new Stack<>();
    private static int inputStackNum = 1;
    private static Deque<String> answer = new LinkedList<>();

    private static boolean config(int num){
        if (num < inputStackNum){
            if (stack.isEmpty() || num != stack.pop())
                return false;
            answer.push("-");
            return true;
        }
        while (num > inputStackNum){
            stack.push(inputStackNum);
            answer.push("+");
            inputStackNum++;
        }
        answer.push("+");
        answer.push("-");
        inputStackNum++;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n > 0){
            if (!config(Integer.parseInt(br.readLine()))){
                answer.clear();
                answer.push("NO");
                break;
            }
            n--;
        }

        while (!answer.isEmpty()){
            System.out.println(answer.pollLast());
        }
    }
}