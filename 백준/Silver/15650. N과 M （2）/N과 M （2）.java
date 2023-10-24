import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(n, m, 0, 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int n, int m, int depth, int start) throws IOException {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(n, m, depth + 1, i + 1);
        }

    }
}
