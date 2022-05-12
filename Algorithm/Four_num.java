10824번 문제풀이​

네 자연수 A, B, C, D가 주어진다. 이때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.
두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다.



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");  // 입력받는 문자열을 공백을 구분자로 나눔

        String a = str[0] + str[1];   // 배열 str의 0번 인덱스와 1번 인덱스 문자열을 합친다
        String b = str[2] + str[3];   //  배열 str의 2번 인덱스와 3번 인덱스 문자열을 합친다

        long c = Long.parseLong(a);  // 합쳐진 문자열 a를 long 타입 정수로 바꿔준다
        long d = Long.parseLong(b);  // 합쳐진 문자열 b를 long 타입 정수로 바꿔준다
        long e = c+d;  // long타입 정수 c와 d를 더한다

        bw.write(e+"\n");   // 더한 정수 e를 출력한다
        bw.flush();
        bw.close();
    }
}