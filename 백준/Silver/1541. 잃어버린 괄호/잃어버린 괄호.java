import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    private static String[] operators;
    private static int[] numbers;

    private static int getMinTotal() {
        if (operators.length == 0)
            return numbers[0];

        int minTotal = 0;
        boolean isPlus = true;
        for (int i = 0 ; i < numbers.length; i++) {
            if (Objects.equals(operators[i], "-"))
                isPlus = false;
            if (isPlus) {
                minTotal += numbers[i];
                continue;
            }
            minTotal -= numbers[i];
        }
        return minTotal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();
        operators = problem.split("\\d{1,5}");
        numbers = Arrays.stream(problem.split("\\+|-")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getMinTotal());
    }
}
