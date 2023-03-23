백준 1735 분수 합 문제

분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.

두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.


< 코드 Java >

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
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long numerator1 = Long.parseLong(st.nextToken());
        long denominator1 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long numerator2 = Long.parseLong(st.nextToken());
        long denominator2 = Long.parseLong(st.nextToken());

        long numerator = numerator1*denominator2 + numerator2*denominator1;
        long denominator = denominator1 * denominator2;

        long gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        bw.write(numerator + " " + denominator + "\n");
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b) {
        if (a % b != 0) {
            return gcd(b, a % b);
        } else {
            return b;
        }
    }
}