백준 11050번 이항 계수 1 문제풀이

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // n 입력받음
        int r = Integer.parseInt(st.nextToken());   // r 입력받음  

        int factoN = factorial(n);   // n 팩토리얼 값
        int factoR = factorial(r);   // r 팩토리얼 값
        int factoSub = factorial(n-r);   // n-r의 팩토리얼 값

        int answer = factoN/(factoR*factoSub);  // 공식을 통해 답을 구함

        bw.write(answer + "\n");   // 답을 출력
        bw.flush();
        bw.close();
    }

    public static int factorial(int n) {
        if(n == 0) {   // n이 0이면,
            return 1;   // 1을 반환
        } else {   // n이 0이 아니면,
            return n * factorial(n-1);   // n-1을 재귀를 통해 값을 구하고 n을 곱함
        }
    }

}