2501번 문제

어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다. 
6을 예로 들면

●   6 ÷ 1 = 6 … 0
●   6 ÷ 2 = 3 … 0
●   6 ÷ 3 = 2 … 0
●   6 ÷ 4 = 1 … 2
●   6 ÷ 5 = 1 … 1
●   6 ÷ 6 = 1 … 0

그래서 6의 약수는 1, 2, 3, 6, 총 네 개이다.
두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());  // 문자열을 입력 받음

        int N = Integer.parseInt(st.nextToken());   // 토큰 하나를 정수로 변환
        int K = Integer.parseInt(st.nextToken());   // 토큰 하나를 정수로 변환
        List<Integer> list = new ArrayList<>();  // 리스트 생성

        for(int i=1; i<= N; i++) {  // N번만큼 반복
            if(N%i == 0) {    // N을 i로 나눴을 때 나머지가 없다면,
                list.add(i);   // i를 리스트에 넣어줌
            }
        }
        Collections.sort(list);   // 리스트를 정렬해줌
        if(list.size() >= K) {    // 리스트 크기가 K보다 크거나 같다면,
        System.out.println(list.get(K-1));   // 리스트의 K-1번째 인덱스를 출력
        } else {    // 리스트 크기가 K보다 작다면,
            System.out.println(0);   // 0을 출력함
        }
    }
}