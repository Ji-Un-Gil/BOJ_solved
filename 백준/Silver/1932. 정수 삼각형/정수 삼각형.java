import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static int[][] accTriangle;

    private static void setAccTriangle(int n, List<Integer> nList){
        accTriangle[n-1] = new int[n];
        for (int i = 0; i < n-1; i++){
            if (accTriangle[n-2][i] + nList.get(i) > accTriangle[n-1][i])
                accTriangle[n-1][i] = accTriangle[n-2][i] + nList.get(i);
            accTriangle[n-1][i+1] = accTriangle[n-2][i] + nList.get(i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        accTriangle = new int[n][];
        accTriangle[0] = new int[1];
        accTriangle[0][0] = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++){
            List<Integer> nList = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            setAccTriangle(i, nList);
        }

        Arrays.sort(accTriangle[n-1]);
        System.out.println(accTriangle[n-1][accTriangle[n-1].length-1]);
    }
}
