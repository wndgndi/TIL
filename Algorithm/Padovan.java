import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];  // 최대 케이스까지 고려하여 배열 생성
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=0; i<n; i++) {   // n번만큼 반복
            int a = Integer.parseInt(br.readLine());   // 문자열 a를 입력받고 정수로 변환
          for(int j=4; j<=a; j++) {  // 배열 dp에 3번 인덱스까지 들어있으므로 4부터 a까지 반복
                dp[j] = dp[j-2] + dp[j-3];   // j번째 인덱스는 (j-2)+(j-3)번째 인덱스와 같음
           }
            System.out.println(dp[a]);  // 배열 dp의 a번째 인덱스 출력
        }
    }
}
