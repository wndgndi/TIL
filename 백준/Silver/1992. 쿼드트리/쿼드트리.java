import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        video = new int[n][];

        for (int i = 0; i < n; i++) {
            video[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        compress(0, 0, n);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void compress(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (video[row][col] == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            return;
        }
        int newSize = size / 2;

        sb.append("(");
        compress(row, col, newSize);
        compress(row, col + newSize, newSize);
        compress(row + newSize, col, newSize);
        compress(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = video[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (video[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}