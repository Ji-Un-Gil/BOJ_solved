import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int left = 0, right = 0, sum = 0, length = 1000001;
        while (right < sequence.length) {
            sum += sequence[right];
            while (sum > k) {
                sum -= sequence[left++];
            }
            if (sum == k && (right - left + 1) < length) {
                length = right - left + 1;
                answer = new int[] {left, right};
            }
            right++;
        }
        return answer;
    }
    /*
    시간 초과
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        int length = 1000001;
        for (int i = 0; i < sequence.length; i++) {
            queue.add(sequence[i]);
            int queueTotal = queue.stream().mapToInt(Integer::intValue).sum();
            while (queueTotal > k) {
                queueTotal -= queue.poll();
            }
            if (queueTotal == k && queue.size() < length) {
                answer = new int[] {i-(queue.size()-1), i};
                length = queue.size();
            }
        }
        return answer;
    }
    */
}