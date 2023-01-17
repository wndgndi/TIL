백준 4344 평균은 넘겠지 문제

첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());  // 테스트 케이스 개수 입력받음
        for(int i=0; i<n; i++) {   // n번만큼 반복
            st = new StringTokenizer(br.readLine());   // 토큰으로 사용할 점수들 입력받음 
            int student = Integer.parseInt(st.nextToken());  // 학생의 수를 토큰으로 받아옴
            List<Integer> list = new ArrayList<>();

            while(st.hasMoreTokens()) {  // 토큰이 존재하는 동안 반복
                list.add(Integer.parseInt(st.nextToken()));  // 토큰들을 리스트에 넣어줌
            }
            int mean = list.stream().mapToInt(Integer::intValue).sum()/student;  // 리스트 점수들의 평균을 구함
            double over = (double) list.stream().filter(x -> x>mean).count();  // 평균 이상 학생 수 구함
            String result = String.format("%.3f", (double) over/student*100);  // 평균을 넘는 학생 수 비율 소수점 셋째자리 까지 구함
            bw.write(result + "%" + "\n");
            bw.flush();
        }
        bw.close();
    }
}


< 코드 Python >

import sys

n = int(sys.stdin.readline())  // 테스트 케이수 수 입력받음

for i in range(n):  // n번만큼 반복
    num_list = list(map(int, sys.stdin.readline().split()))  //  입력받은 문자열 나눠서 리스트로 만들어줌
    student = num_list[0]  // 학생 수는 리스트의 0번째 인덱스 값
    del num_list[0]  // 리스트의 0번째 인덱스 지워줌
    mean = sum(num_list)/student   // 리스트 점수들의 평균값 구함
    over = len(list(filter(lambda x: x > mean, num_list)))   // 평균 이상의 학생 수 구함

    print("{:.3f}".format(over/student*100) + "%")  // 평균 이상의 비율을 소수점 셋째 자리까지 출력
    