2747번 문제

피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
n=17일때 까지 피보나치 수를 써보면 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.


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
