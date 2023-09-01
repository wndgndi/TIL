import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] price;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        price = new int[n][3];
        dp = new int[n][3];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            price[i][Red] = Integer.parseInt(st.nextToken());
            price[i][Green] = Integer.parseInt(st.nextToken());
            price[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = price[0][Red];
        dp[0][Green] = price[0][Green];
        dp[0][Blue] = price[0][Blue];

        bw.write(Math.min(find_price(n-1, Red), Math.min(find_price(n-1, Green), find_price(n-1, Blue))) + "\n");
        bw.flush();
        bw.close();
    }

    public static int find_price(int n, int color) {

        if(dp[n][color] == 0) {
            if(color == Red) {
                dp[n][Red] = Math.min(find_price(n-1, Green), find_price(n-1, Blue)) + price[n][Red];
            } else if(color == Green) {
                dp[n][Green] = Math.min(find_price(n-1, Red), find_price(n-1, Blue)) + price[n][Green];
            } else {
                dp[n][Blue] = Math.min(find_price(n-1, Red), find_price(n-1, Green)) + price[n][Blue];
            }
        }

        return dp[n][color];
    }

}
