1439번 문제

다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다. 다솜이가 할 수 있는 행동은 
S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.

    1.  예를 들어 S=0001100 일 때,
    2.  전체를 뒤집으면 1110011이 된다.

4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = br.readLine();   // 검사할 문자열 입력받음
            StringTokenizer zero = new StringTokenizer(str, "0");   // 0을 구분자로 나눠줌
            StringTokenizer one = new StringTokenizer(str, "1");    // 1을 구분자로 나눠줌
            String[] S = str.split("");  // 입력받은 문자열을 한글자씩 나눠줌

            int cnt=0;  // 뒤집는 횟수 계산을 위한 변수

            if(zero.countTokens() > one.countTokens()) {   // 0을 뒤집는 횟수가 1을 뒤집는 횟수보다 많다면  
                for(int i=0; i<=str.length()-1; i++) {    // str 길이-1 만큼 반복 
                    if(S[i].equals("0") && !S[i+1].equals("0")) {  // i번째 인덱스가 0이고 다음 인덱스가 0이 아니라면,
                        cnt++;  // cnt에 1을 증가시킴
                    }
                }
            } else if(one.countTokens() > zero.countTokens()) {  // 1을 뒤집는 횟수가 0을 뒤집는 횟수보다 많다면,
                for(int i=0; i<=str.length()-1; i++) {   // str의 길이-1 만큼 반복
                    if(S[i].equals("1") && !S[i+1].equals("1")) {   // i번째 인덱스가 1이고 다음 인덱스가 1이 아니라면,
                        cnt++;   // cnt에 1을 증가시킴
                    }
                }
            } else if(one.countTokens() == zero.countTokens()) {  // 1을 뒤집는 횟수가 0을 뒤집는 횟수와 같다면,
                cnt = one.countTokens();  // 어차피 두 토큰 수가 같으므로 토큰 수를 cnt 값으로 지정 
            }
        System.out.println(cnt);  // cnt의 값을 출력
    }
}