1934번 문제풀이

두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.


import java.io.*;

public class Main {

    public static int gcd(int a, int b) {  // 최소공배수를 구하기 위해 최대공약수 구함
        if(b==0) return a;     // b가 0이면 a를 리턴
        else return gcd(b, a%b);   // b가 0이 아니면 gcd에 b와 a%b를 인자로 전달하며 재귀호출
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());   // 문자열 n을 입력받고 정수로 변환

        for(int i=0; i<n; i++) {     // n번 반복
            String[] str = br.readLine().split(" ");   // 입력받은 문자열 공백을 기준으로 나눔
            int a = Integer.parseInt(str[0]);  // str 배열의 0번 인덱스 정수로 변환
            int b = Integer.parseInt(str[1]);  // str 배열의 1번 인덱스 정수로 변환
            int gcd = gcd(a,b);   // a와 b를 gcd의 인자로 사용
            int lcm = (a*b)/gcd;  // (a*b)/gcd를 계산하면 최소공배수
            bw.write(lcm + "\n");  // lcm 출력
        }
        bw.flush();
        bw.close();
    }
}