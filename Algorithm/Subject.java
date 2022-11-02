백준 5597 과제 안 내신 분..? 문제

﻿
X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.

교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = new Integer[28];   // 크기가 28인 배열을 생성

        for(int i=0; i<28; i++) {    // 28번 반복
            arr[i] = Integer.parseInt(br.readLine());   // 배열의 인덱스들에 값을 입력해줌
        }

        for(int i=1; i<=30; i++) {     // 30번 반복
            if(!Arrays.asList(arr).contains(i)) {    // 배열 arr에 i를 포함하고 있는지 확인
                System.out.println(i);    // 포함하고 있지 않다면 i를 출력
            }
        }

    }
}