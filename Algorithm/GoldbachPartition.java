백준 17103 골드바흐 파티션 문제

골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 
두 소수의 순서만 다른 것은 같은 파티션이다.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[] prime = new boolean[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        setPrime();   // 소수 판별

        for (int i = 0; i < n; i++) {   // n번 반복
            int num = Integer.parseInt(br.readLine());   // 테스트 케이스를 정수로 변환
            int cnt = 0;   // 파티션 개수를 세기 위한 변수
            for (int j = 2; j <= (num / 2); j++) {   // num의 절반만큼 반복 (반을 넘어가면 중복되므로)
                if(!prime[j] && !prime[num-j]) {   // j가 소수이고 num-j 또한 소수일 경우,
                    cnt++;   // cnt가 1 증가
                }
            }
            bw.write(cnt + "\n");   // cnt를 출력
        }

        bw.flush();
        bw.close();

    }

    public static void setPrime() {
        prime[0] = true;   
        prime[1] = true; 

        for (int i = 2; i * i < 1000000; i++) {  
            for (int j = i * i; j < 1000000; j += i) {
                if (prime[j] == false) { 
                    prime[j] = true;
                }
            }
        }
    }
}