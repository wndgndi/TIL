import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][n+1];
        int[][] map = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        dp[1][1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == n && j == n) {
                    continue;
                }
                int next = map[i][j];
                if(i + next <= n) {
                    dp[i + next][j] += dp[i][j];
                }

                if(j + next <= n) {
                    dp[i][j + next] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
