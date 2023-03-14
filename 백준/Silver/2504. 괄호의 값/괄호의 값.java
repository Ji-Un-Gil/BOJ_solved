import java.io.*;
import java.util.Stack;

public class Main {

    private static final int smallBracket = -1;
    private static final int bigBracket = -2;
    private static final int smallPair = 2;
    private static final int bigPair = 3;
    private static final Stack<Integer> stack = new Stack<>();

    private static boolean compareBracket(int bracket, char character) {
        if (bracket == -1 && character == ')')
            stack.push(smallPair);
        else if (bracket == -2 && character == ']')
            stack.push(bigPair);
        else return true;
        return false;
    }

    private static int getX(String string) {
        int idx = 0, X = 0;
        while (idx < string.length()) {
            char character = string.charAt(idx);
            if (character == '(')
                stack.push(smallBracket);
            else if (character == '[')
                stack.push(bigBracket);
            else {
                if (stack.isEmpty())
                    return 0;
                int partX = stack.pop();
                if (partX > 0) {
                    if (stack.isEmpty() || compareBracket(stack.pop(), character))
                        return 0;
                    stack.push(partX * stack.pop());
                }
                else {
                    if (compareBracket(partX, character))
                        return 0;
                }
                if (stack.size() >= 2) {
                    partX = stack.pop();
                    int recentPart = stack.pop();
                    while (recentPart > 0 && !stack.isEmpty()) {
                        stack.push(recentPart + partX);
                        partX = stack.pop();
                        recentPart = stack.pop();
                    }
                    stack.push(recentPart);
                    stack.push(partX);
                }
            }
            idx++;
        }
        while (!stack.isEmpty()) {
            int partX = stack.pop();
            if (partX < 0)
                return 0;
            X += partX;
        }
        return X;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(String.valueOf(getX(input)));
        bw.flush();
    }
}
