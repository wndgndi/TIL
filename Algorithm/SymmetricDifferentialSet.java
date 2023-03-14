백준 1269번 문제

자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오. 
두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.

예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SymmetricDifferentialSet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());  // 문자열 토큰으로 입력받음

        int n = Integer.parseInt(st.nextToken());   //  집합 A의 원소 개수
        int m = Integer.parseInt(st.nextToken());   //  집합 B의 원소 개수

        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());   // 문자열 토큰으로 입력받음
        int cnt = st.countTokens();   // cnt에 토큰 개수를 값으로 선언 및 초기화

        while(st.hasMoreTokens()) {   // st에 토큰이 남아있다면 반복
            set.add(Integer.parseInt(st.nextToken()));  // set에 토큰 값을 정수로 변환하여 넣어줌
        }

        st = new StringTokenizer(br.readLine());   // 문자열 토큰으로 입력받음
        while(st.hasMoreTokens()) {   // set에 토큰 값을 정수로 변환하여 넣어줌
            if (set.contains(Integer.parseInt(st.nextToken()))) {  // set에 정수로 변환한 토큰 값이 이미 존재한다면,
                cnt--;   // cnt는 1 감소  (겹치는 값은 빼줌)
            } else {   // set에 정수로 변환한 토큰 값이 존재하지 않는다면,
                cnt++;   // cnt가 1 증가
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }

}
