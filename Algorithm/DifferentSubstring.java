백준 11478번 문제

문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        HashSet<String> set = new HashSet<>();  // 중복을 피하기 위해 set 사용

        for(int i=0; i<s.length(); i++) {   // 문자열 s의 길이만큼 반복
            for(int j=i+1; j<=s.length(); j++) {  
                set.add(s.substring(i, j));  // 문자열 s를 i부터 j인덱스까지 잘라냄
            }
        }

        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
    }

}