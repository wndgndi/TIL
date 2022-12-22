백준 1181번 문제

알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로


< 코드 >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());   // 단어의 개수 입력받음
        List<String> str = new ArrayList<>();

         for(int i=0; i<n; i++) {    // n번만큼 반복
             str.add(br.readLine());   // 리스트 str에 단어 추가
         }

         str = str.stream().distinct()  // str을 스트림으로 변환 후, 중복 단어 제거
                 .collect(Collectors.toList());  // 리스트로 만들어줌

        str.sort((a, b) -> {  
            if (a.length() == b.length()) {  // 단어 a와 b의 길이가 같다면,
                return a.compareTo(b);   // 단어 a와 b를 사전순으로 정렬
            } else {   // 단어 a와 b의 길이가 다르면,
                return a.length() - b.length();   // 단어 a와 b를 길이순으로 정렬
            }
        });

         for(int i=0; i<str.size(); i++) {    // 리스트 str의 크기만큼 반복
             bw.write(str.get(i) + "\n");   // str의 i번째 인덱스를 출력
         }
         bw.flush();
         bw.close();
    }

}