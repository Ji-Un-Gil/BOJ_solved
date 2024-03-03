import java.util.Map;
import java.util.HashMap;

class Solution {
    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, int[]> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.putIfAbsent(a, new int[]{0, 0});
            graph.putIfAbsent(b, new int[]{0, 0});

            graph.get(a)[0]++;
            graph.get(b)[1]++;
        }

        for (Map.Entry<Integer, int[]> entry : graph.entrySet()) {
            int key = entry.getKey();
            int[] value = entry.getValue();

            if (value[0] >= 2 && value[1] == 0) {
                answer[0] = key;
            }
        }

        int total = graph.get(answer[0])[0];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if (a != answer[0]) continue;

            graph.get(b)[1]--;
        }

        for (Map.Entry<Integer, int[]> entry : graph.entrySet()) {
            int[] value = entry.getValue();

            if (value[0] == 0 && value[1] >= 0) {
                answer[2]++;
            } else if (value[0] == 2 && value[1] == 2) {
                answer[3]++;
            }
        }

        answer[1] = total - (answer[2] + answer[3]);
        return answer;
    }
}

/*
도넛 : 모두 2번 호출
막대 : 처음과 끝 1번 호출, 중간은 2번 호출
8자 : 나머지 2번 호출, 중간은 4번 호출

11 5번 호출 >> 11이 시작점인 거에서부터 찾아서 소거, 11이 아직 남아있는 케이스에서 시작번호가 시작(4)
2 1번 호출 >> 2 관련된 거 찾아서 소거(2가 시작 또는 끝인..)
나머지 남은 건 도넛 형태, 아무 점이나 시작해서 찾으며 소거.
*/