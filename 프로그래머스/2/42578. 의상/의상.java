import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> dic = new HashMap<>();

        for (String[] cloth : clothes) {
            if (!dic.containsKey(cloth[1])) {
                dic.put(cloth[1], 0);
            }
            dic.put(cloth[1], dic.get(cloth[1]) + 1);
        }

        for (int count : dic.values()) {
            answer *= (count + 1);
        }
        answer--;

        return answer;
    }
}
