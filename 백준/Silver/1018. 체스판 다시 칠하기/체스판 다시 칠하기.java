import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] board = new String[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split("");
        }

        solve(n, m, board);

        int min = solve(n, m, board);


        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    private static int solve(int n, int m, String[][] board) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                String[][] split = new String[8][8];
                for (int k = 0; k < 8; k++) {
                    split[k] = Arrays.copyOfRange(board[i + k], j, j + 8);
                }
                int cnt1 = patinBoard(split, "B");
                int cnt2 = patinBoard(split, "W");
                min = Math.min(min, Math.min(cnt1, cnt2));
            }
        }
        return min;
    }

    public static int patinBoard(String[][] split, String startColor) {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String correctColor = (i+j) % 2 == 0 ? startColor : ("B".equals(startColor) ? "W" : "B");
                if (!split[i][j].equals(correctColor)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
