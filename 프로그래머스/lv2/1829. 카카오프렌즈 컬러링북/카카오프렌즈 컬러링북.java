class Solution {
    private static int checkSameColor(int i, int j, int[][] picture, int[][] isVisited, int color, int total) {
        if (i < 0 || i >= picture.length || j < 0 || j >= picture[0].length || color == 0 || color != picture[i][j] || isVisited[i][j] == 1)
            return total;

        isVisited[i][j] = 1;
        total += 1;

        total = checkSameColor(i-1, j, picture, isVisited, color, total);
        total = checkSameColor(i, j-1, picture, isVisited, color, total);
        total = checkSameColor(i+1, j, picture, isVisited, color, total);
        total = checkSameColor(i, j+1, picture, isVisited, color, total);

        return total;
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] isVisited = new int[m][n];

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total = checkSameColor(i, j, picture, isVisited, picture[i][j], 0);
                if (total > 0) {
                    numberOfArea += 1;
                    if (total > maxSizeOfOneArea)
                        maxSizeOfOneArea = total;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}