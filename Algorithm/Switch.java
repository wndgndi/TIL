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