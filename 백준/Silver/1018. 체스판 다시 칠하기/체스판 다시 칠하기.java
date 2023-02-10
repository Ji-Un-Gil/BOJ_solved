import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final char[][] targetBoard = {{'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'}};
    private static int minMiss = 33;

    private static void changeMinMiss(int count) {
        if (count > 32)
            count = 64 - count;
        if (count < minMiss)
            minMiss = count;
    }

    private static int findMisses(char[][] compareBoard, int startRow, int startColumn) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (targetBoard[i][j] != compareBoard[startRow+i][startColumn+j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        char[][] inputBoard = new char[row][column];

        for (int i = 0; i < row; i++)
            inputBoard[i] = br.readLine().toCharArray();

        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < column - 7; j++)
                changeMinMiss(findMisses(inputBoard, i, j));
        }

        System.out.println(minMiss);
    }
}
