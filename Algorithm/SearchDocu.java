1543번 문제

세준이는 영어로만 이루어진 어떤 문서를 검색하는 함수를 만들려고 한다. 이 함수는 어떤 단어가 총 몇 번 등장하는지 세려고 한다. 그러나, 세준이의 함수는 중복되어 세는 것은 빼고 세야 한다. 
예를 들어, 문서가 abababa이고, 그리고 찾으려는 단어가 ababa라면, 세준이의 이 함수는 이 단어를 0번부터 찾을 수 있고, 2번부터도 찾을 수 있다. 그러나 동시에 셀 수는 없다.
세준이는 문서와 검색하려는 단어가 주어졌을 때, 그 단어가 최대 몇 번 중복되지 않게 등장하는지 구하는 프로그램을 작성하시오.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();   // StringBulder에 담고 체크할 문자열
        String str2 = br.readLine();   // 개수를 셀 기준이 되는 문자열

        sb.append(str1);  // str1을 Sb에 넣어줌
        int cnt = 0;     // 개수를 세기 위한 변수 

       while(sb.toString().indexOf(str2) != -1) {   // 문자열 str2가 sb에 존재할 동안 반복
           int n = sb.toString().indexOf(str2);   // str2가 시작되는 첫번째 인덱스
           cnt++;  // cnt를 1씩 증가시켜줌

           sb.delete(0, n+str2.length());   // cnt를 증가시켰으므로 이미 체크한 str2는 지워줌

       }
        System.out.println(cnt);   // 개수 cnt를 출력
    }
}

while(sb.toString().indexOf(str2) != -1)은  while(str1.contain(str2))와 비슷하다고 볼 수 있다.