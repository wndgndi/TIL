20053번 문제

N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
​

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수 입력

        for(int i=0; i<n; i++) {   // n번만큼 반복
            int a = Integer.parseInt(br.readLine());   // 정수의 개수 a 입력
            StringTokenizer st = new StringTokenizer(br.readLine());  // 문자열 형태의 정수를 공백으로 구분해서 입력
            int[] arr = new int[a];    // a 크기의 정수 배열 생성
            for(int j=0; j<a; j++) {    // a번만큼 반복
                arr[j] = Integer.parseInt(st.nextToken());  // st의 토큰이 없을때까지 정수로 변환하여 arr에 넣어줌
            }
            Arrays.sort(arr);   // 배열 arr 정렬
            System.out.println(arr[0] + " " + arr[a-1]);  
        }
    }
}