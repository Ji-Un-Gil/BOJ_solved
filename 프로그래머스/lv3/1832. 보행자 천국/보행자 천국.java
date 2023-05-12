import java.util.ArrayList;
import java.util.Objects;

public class Solution {
    static int MOD = 20170805;

    private static void accumulateMap(int i, int j, int[][] cityMap, int[][][] result) {
        if (cityMap[i][j] == 1)
            return;
        if (cityMap[i][j] == 0) {
            result[i+1][j][0] = (result[i][j][0] + result[i][j][1]) % MOD;
            result[i][j+1][1] = (result[i][j][0] + result[i][j][1]) % MOD;
            return;
        }
        result[i+1][j][0] = result[i][j][0] % MOD;
        result[i][j+1][1] = result[i][j][1] % MOD;
    }

    public static int solution(int m, int n, int[][] cityMap) {

        int[][][] result = new int[m+1][n+1][2];
        result[0][0][0] = 1;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                accumulateMap(i, j, cityMap, result);

        return (result[m-1][n-1][0] + result[m-1][n-1][1]) % MOD;
    }
}