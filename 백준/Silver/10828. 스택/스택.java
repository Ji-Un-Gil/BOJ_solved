import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static StringTokenizer st;
    private static Stack<Integer> stack = new Stack<>();

    private static void config(String line){
        st = new StringTokenizer(line);
        switch (st.nextToken()){
            case "push":
                stack.add(Integer.parseInt(st.nextToken()));
                break;
            case "pop":
                try{
                    System.out.println(stack.pop());
                }catch(EmptyStackException e){
                    System.out.println(-1);
                }
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                if (stack.empty()){
                    System.out.println(1);
                    break;
                }
                System.out.println(0);
                break;
            case "top":
                try {
                    System.out.println(stack.peek());
                }catch(EmptyStackException e){
                    System.out.println(-1);
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N > 0){
            config(br.readLine());
            N--;
        }
    }
}
