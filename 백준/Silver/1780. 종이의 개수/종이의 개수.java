import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[][] paper;
    static int negative = 0;
    static int zero = 0;
    static int positive = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        }

        split(0, 0, n);
        bw.write(negative + "\n" + zero + "\n" + positive + "\n");
        bw.flush();
        bw.close();
    }

    public static void split(int row, int col, int size) {
        if (valueCheck(row, col, size)) {
            if (paper[row][col] == 1) {
                positive++;
            } else if (paper[row][col] == 0) {
                zero++;
            } else {
                negative++;
            }
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                split(row + (newSize * i), col + (newSize * j), newSize);
            }
        }
    }

    public static boolean valueCheck(int row, int col, int size) {
        int value = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
