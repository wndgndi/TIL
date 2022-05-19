2475번 문제풀이

컴퓨터를 제조하는 회사인 KOI 전자에서는 제조하는 컴퓨터마다 6자리의 고유번호를 매긴다. 고유번호의 처음 5자리에는 00000부터 99999까지의 수 중 하나가 주어지며 6번째 자리에는 검증수가 들어간다. 검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.
예를 들어 고유번호의 처음 5자리의 숫자들이 04256이면, 각 숫자를 제곱한 수들의 합 0+16+4+25+36 = 81 을 10으로 나눈 나머지인 1이 검증수이다.
​

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v, sum = 0;  // 제곱수와 합계를 담기 위한 변수

        for(int i=0; i<5; i++) {    // 5번 반복
            int n = Integer.parseInt(st.nextToken());   // 입력받은 단어 잘라서 가져옴
            v = n*n;   // 정수 n의 제곱값을 v에 넣어줌
            sum += v;   // v의 합계를 sum에 넣어줌
        }
        bw.write((sum%10)+"\n");   // sum을 10으로 나눈 나머지 출력
        bw.flush();
        bw.close();
    }
}
