백준 25501 문제

정휘는 후배들이 재귀 함수를 잘 다루는 재귀의 귀재인지 알아보기 위해 재귀 함수와 관련된 문제를 출제하기로 했다.

팰린드롬이란, 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열을 말한다. 팰린드롬의 예시로 AAA, ABBA, ABABA 등이 있고, 팰린드롬이 아닌 문자열의 예시로 ABCA, PALINDROME 등이 있다.

어떤 문자열이 팰린드롬인지 판별하는 문제는 재귀 함수를 이용해 쉽게 해결할 수 있다. 아래 코드의 isPalindrome 함수는 주어진 문자열이 팰린드롬이면 1, 팰린드롬이 아니면 0을 반환하는 함수다.

public class Main{
    public static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
        System.out.println("ABBA: " + isPalindrome("ABBA"));
        System.out.println("ABC: " + isPalindrome("ABC"));
    }
}

정휘는 위에 작성된 isPalindrome 함수를 이용하여 어떤 문자열이 팰린드롬인지 여부를 판단하려고 한다.

구체적으로는, 문자열 S를 isPalindrome 함수의 인자로 전달하여 팰린드롬 여부를 반환값으로 알아낼 것이다. 더불어 판별하는 과정에서 recursion 함수를 몇 번 호출하는지 셀 것이다.

정휘를 따라 여러분도 함수의 반환값과 recursion 함수의 호출 횟수를 구해보자.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());   // 문자열 입력 반복 횟수

        for(int i=0; i<n; i++) {   // n번 반복
            cnt = 0;   // cnt를 초기화
            String s = br.readLine();   // 문자열 입력받음
            bw.write(isPalindrome(s) + " " + cnt + "\n");   // 팰리드롬 결과와 함수 호출 횟수 출력
        }
        bw.flush();
        bw.close();
    }

    public static int recursion(String s, int l, int r) {
        cnt++;   // cnt가 1 증가
        if(l >= r) return 1;    //  문자열을 모두 비교해서 팰린드롬인지 확인했다면 1을 반환
        else if(s.charAt(l) != s.charAt(r)) return 0;   // 문자가 달라서 팰린드롬이 아니면 0 반환
        else return recursion(s, l+1, r-1);   // 양 끝에서 한 문자씩 비교하기 위해 재귀호출
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);  
    }

}
