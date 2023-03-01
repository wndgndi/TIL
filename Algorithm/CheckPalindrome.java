백준 10988 문제

알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.

팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 

level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();  // 문자열 입력받음
        StringBuilder sb = new StringBuilder(str); // 입력받은 문자열 sb에 넣어줌

        if(str.equals(sb.reverse().toString())) {  // sb를 뒤집은 문자열이 str과 같다면,
            bw.write("1");  // 1을 출력 
        } else {   // sb를 뒤집은 문자열이 str과 다르면,
            bw.write("0");   // 0을 출력
        }
        bw.flush();
        bw.close();
    }
}
