import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class Main {

    private static Stack<Character> stack = new Stack<>();

    private static String checkVPS(String string){
        stack.clear();
        for (int i = 0; i < string.length(); i++){
            switch (string.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return "no";
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return "no";
                    break;
            }
        }
        if (!stack.isEmpty())
            return "no";
        return "yes";
    }

    public static void main(String[] args) throws IOException {
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        while (!Objects.equals(line, ".")){
            System.out.println(checkVPS(line));
            line = br.readLine();
        }
    }
}
