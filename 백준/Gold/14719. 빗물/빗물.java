import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    // static StringBuilder sb = new StringBuilder();
    static int x, y;
    static int[] world;

    // 1. x, y 입력
    private static void inputXY() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        world = new int[y];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < y; i++) {
            world[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int getRainTotal() {
        int total = 0;
        ArrayList<Integer> BlockIdx;
        while (x > 0) {
            BlockIdx = new ArrayList<>();
            for (int i = 0; i < y; i++) {
                if (world[i] >= x)
                    BlockIdx.add(i);
            }
            x--;
            if (BlockIdx.size() < 2)
                continue;
            for (int j = 0; j < BlockIdx.size() - 1; j++) {
                total += (BlockIdx.get(j+1) - BlockIdx.get(j) - 1);
            }
        }
        return total;
    }

    private static void outputTotal(int total) {
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        inputXY();
        outputTotal(getRainTotal());
    }
}
