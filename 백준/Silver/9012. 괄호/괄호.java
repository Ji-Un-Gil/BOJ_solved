import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    private static String checkVPS(String string){
        int ps = 0;
        for (int i = 0; i < string.length(); i++){
            if (Objects.equals(string.charAt(i), '('))
                ps++;
            else
                ps--;
            if (ps < 0)
                return "NO";
        }
        if (ps != 0)
            return "NO";
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0){
            System.out.println(checkVPS(br.readLine()));
            T--;
        }
    }
}
