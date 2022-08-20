import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());   //  n번째 피보나치 수를 구하기 위해 n을 정수로 변환
            long[] dp = new long[n+1];   // int 범위를 넘어갈 수 있으므로 long으로 배열 생성
            dp[0] = 0;    // dp의 0번째 인덱스 정해줌
            dp[1] = 1;    // dp의 1번째 인덱스 정해줌

            for(int i=2; i<=n; i++) {    // 2부터 n까지 반복
                dp[i] = dp[i-1] + dp[i-2];    // dp의 i번째 인덱스는 (i-1)인덱스 + (i-2)인덱스와 같음
            }

        System.out.println(dp[n]);   // n번째 피보나치 수 출력
    }
}
