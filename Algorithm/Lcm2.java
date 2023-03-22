백준 13241 최소공배수 문제풀이

정수 B에 0보다 큰 정수인 N을 곱해 정수 A를 만들 수 있다면, A는 B의 배수이다.

예:

10은 5의 배수이다 (5*2 = 10)
10은 10의 배수이다(10*1 = 10)
6은 1의 배수이다(1*6 = 6)
20은 1, 2, 4,5,10,20의 배수이다.
다른 예:

2와 5의 최소공배수는 10이고, 그 이유는 2와 5보다 작은 공배수가 없기 때문이다.
10과 20의 최소공배수는 20이다.
5와 3의 최소공배수는 15이다.
당신은 두 수에 대하여 최소공배수를 구하는 프로그램을 작성 하는 것이 목표이다.


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
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());  // A 입력받아서 정수로 변환
        long b = Integer.parseInt(st.nextToken());  // B 입력받아서 정수로 변환
        long lcm = (a*b)/gcd(a,b);  // a와 b의 곱을 최대공약수로 나누면 최소공배수임

        bw.write(lcm + "\n");   // 최소공배수 출력
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b) {  
        if(a%b == 0) {    // a와 b의 나머지가 0이면,
            return b;   // b를 반환함
        } else {   // a와 b의 나머지가 0이 아니면,
            return gcd(b, a%b);   // 매개변수를 바꿔서 gcd를 다시 호출함
        }
    }

}
