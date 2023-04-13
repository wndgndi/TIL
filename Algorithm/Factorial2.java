27433 팩토리얼 2 문제

0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.


< Java 코드 >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static long sum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(factorial(n) + "\n");
        bw.flush();
        bw.close();

    }

    public static long factorial(int n) {
        if(n == 0) {
            return sum;
        }
        sum *= n;
        return factorial(n-1);
    }
}