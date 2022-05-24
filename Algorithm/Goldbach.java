6588번 문제풀이

1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
이 추측은 아직도 해결되지 않은 문제이다.
백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[1000001]; // 테스트 케이스의 개수

        List<Integer> prime = new ArrayList<>();  // 소수의 개수를 모르므로 리스트 사용

        check[0] = check[1] = true;  // 0과 1은 소수가 아니므로 true

            for (int i = 2; i < 1000001; i++) {   // 2부터 1000000까지 반복
                if(check[i] == true) {    // 배열 check의 i번째 인덱스가 true 일 경우
                    continue;  // conitnue 한다
                }
                else if(check[i] == false){   // 배열 check의 i번째 인덱스가 false인 경우
                    prime.add(i);    // 리스트 prime에 i를 추가한다.
                }
                for(int j=i+i; j<1000001; j+=i) {  // j를 i+i로 시작해서 배수들을 지워줌
                    check[j] = true;  // 배열 check의 j번째 인덱스들을 true로 바꿔줌
                }
            }

            while(true) {     // true일 동안
                int n = Integer.parseInt(br.readLine());   // 정수 n을 입력받는다
                if(n == 0) break;   // 입력받은 정수가 0이면 break

                for(int i=0; i<n; i++) {    // n번 반복
                    if(check[n-prime.get(i)] == false) {    
  // n에서 리스트 prime의 i번째 인덱스의 값을 빼준 값을 배열 check의 인덱스로써 false일 경우
                        bw.write(n + " = " + prime.get(i) + " + " + (n-prime.get(i)) + "\n");
                        break;
                    }
                }
            }
        bw.flush();
        bw.close();
    }
}