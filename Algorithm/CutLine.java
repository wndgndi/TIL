25305번 문제

2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에  N명의 학생들이 응시했다.
이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열을 입력받아서 토큰으로 나눔

        int a = Integer.parseInt(st.nextToken());  // st의 첫번째 토큰을 정수로 변환
        int b = Integer.parseInt(st.nextToken());  // st의 두번째 토큰을 정수로 변환

        StringTokenizer st2 = new StringTokenizer(br.readLine());  // 문자열을 입력받아서 토큰으로 나눔
        Integer[] arr = new Integer[st2.countTokens()];  // st2의 토큰 개수의 크기를 가진 배열 생성


        for(int i=0; i<arr.length; i++) {  // arr의 길이만큼 반복
            arr[i] = Integer.parseInt(st2.nextToken());   // st2의 토큰을 정수로 변환해서 arr에 넣어줌
        }
        Arrays.sort(arr, Collections.reverseOrder());  // 배열 arr을 역순으로 정렬

        System.out.println(arr[b-1]);  // arr의 b-1번째 인덱스값 출력

    }
}
