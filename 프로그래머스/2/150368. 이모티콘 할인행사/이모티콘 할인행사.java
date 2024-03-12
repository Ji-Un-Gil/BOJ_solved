import java.util.*;

class Solution {
    // 브루트포스    
    static List<int[]> permutationList = new ArrayList<>();

    private static void permutation(int[] arr, int idx, int size) {
        if (idx == size) {
            permutationList.add(arr.clone());
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[idx] = i;
            permutation(arr, idx+1, size);
        }
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] arr = new int[emoticons.length];

        permutation(arr, 0, emoticons.length);
        int[][] purchase = new int[users.length][permutationList.size()];
        double[] saleAfter = {0.9, 0.8, 0.7, 0.6};

        for (int idx = 0; idx < users.length; idx++) {
            for (int i = 0; i < purchase[0].length; i++) {
                for (int j = 0; j < emoticons.length; j++) {
                    if ((100-users[idx][0])*0.01 >= saleAfter[permutationList.get(i)[j]])
                        purchase[idx][i] += emoticons[j] * saleAfter[permutationList.get(i)[j]];
                }
            }
        }

        int maxTotal = 0, maxPlus = 0;
        for (int cases = 0; cases < purchase[0].length; cases++) {
            int total = 0, plus = 0;
            for (int user = 0; user < purchase.length; user++) {
                if (purchase[user][cases] >= users[user][1])
                    plus++;
                else
                    total += purchase[user][cases];
            }
            if (plus > maxPlus || (plus == maxPlus && total > maxTotal)) {
                maxPlus = plus;
                maxTotal = total;
            }
        }

        int[] answer = {maxPlus, maxTotal};
        return answer;
    }
}