9461번 문제

아래 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 
나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.


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
