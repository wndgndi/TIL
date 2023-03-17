백준 14425번 문제

총 N개의 문자열로 이루어진 집합 S가 주어진다.

입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());  // 문자열 토큰으로 입력받음
        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());   // 집합 S에 포함되어 있는 문자열 개수
        int m = Integer.parseInt(st.nextToken());   // 검사해야 하는 문자열 개수
        int cnt = 0;  // 포함된 개수를 세기 위한 변수

        for(int i=0; i<n; i++) {   // n번만큼 반복
            set.add(br.readLine());   // set에 문자열 넣어줌
        }

        for(int i=0; i<m; i++) {   // m번만큼 반복
            if(set.contains(br.readLine())) {   // set에 입력받은 문자열이 포함되어 있다면,
                cnt++;  // cnt가 1 증가
            }
        }

        bw.write(cnt + "\n"); 
        bw.flush();
        bw.close();
    }
}
