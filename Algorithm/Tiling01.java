import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 2진 수열의 개수를 구하기 위한 자리수 입력해서 
                                                  // 정수로 변환

        long[] dp = new long[n+100];  // 배열 크기에 100을 더하여 넉넉하게 만들어줌
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4; i<=n; i++) {   // 4번째 인덱스부터 n번째 인덱스까지 반복
            dp[i] = (dp[i - 1] + dp[i - 2])%15746;  // i번째 인덱스는 (i-1)+(i-1)와 같음
        }
        System.out.println(dp[n]);  // n번째 인덱스를 출력
    }
}
