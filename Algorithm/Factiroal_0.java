1676번 문제

N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

​

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(n >=5) {   // 정수 n이 5보다 크거나 같을 때까지 반복
            cnt += n/5;  // 정수n을 5로 나눈 값을 cnt에 누적해서 더해준다
            n /= 5;  // n을 5로 나누고 그 값을 n으로 사용한다
        }
        bw.write(cnt+"\n");   // 정수 cnt를 출력한다
        bw.flush();
        bw.close();
    }
}