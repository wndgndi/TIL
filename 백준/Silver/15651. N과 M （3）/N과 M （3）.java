import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0);
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth) {
        if(depth == m) {
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++) {
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}