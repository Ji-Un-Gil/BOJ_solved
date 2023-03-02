import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ", true);
        StringBuilder sb = new StringBuilder();
        String word;
        boolean isReverse = true;
        while (st.hasMoreTokens()) {
            word = st.nextToken();
            StringBuilder subWord = new StringBuilder();
            int idx = 0;
            while (idx < word.length()) {
                if (word.charAt(idx) == '<') {
                    isReverse = false;
                    sb.append(subWord.reverse());
                    subWord.setLength(0);
                }

                subWord.append(word.charAt(idx));

                if (word.charAt(idx) == '>') {
                    isReverse = true;
                    sb.append(subWord);
                    subWord.setLength(0);
                }
                idx++;
            }
            if (subWord.length() > 0) {
                if (isReverse)
                    sb.append(subWord.reverse());
                else
                    sb.append(subWord);
            }
        }
        System.out.println(sb);
    }
}
