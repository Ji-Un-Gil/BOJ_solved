import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> problem = new ArrayList<>();
    private static List<Integer> accProblem = new ArrayList<>();
    private static List<Integer> request = new ArrayList<>(2);

    private static void setProblem(int num, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (num > 0){
            problem.add(Integer.parseInt(st.nextToken()));
            num--;
        }
        setAccProblem();
    }

    private static void setAccProblem(){
        int total = 0;
        accProblem.add(total);
        for (int i = 0; i < problem.size(); i++){
            total += problem.get(i);
            accProblem.add(total);
        }
    }

    private static int addRequest(int i, int j){
        return accProblem.get(j) - accProblem.get(i-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] condition = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        setProblem(condition[0], br);
        for (int i = 0; i < condition[1]; i++) {
            st = new StringTokenizer(br.readLine());
            request = List.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            System.out.println(addRequest(request.get(0), request.get(1)));
        }
    }
}
