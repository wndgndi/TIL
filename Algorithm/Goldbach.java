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