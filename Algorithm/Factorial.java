10872번 문제풀이

0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 1;

        if (n == 0) {
            bw.write("1\n");
        } else {
            for (int i = n; i > 0; i--) {
                num *= i;
            }
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }
}