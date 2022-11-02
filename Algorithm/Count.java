백준 10807 개수 세기 문제

총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());    // 정수의 개수
        String[] str = br.readLine().split(" ");    // 입력받은 문자열을 공백을 구분자로 나눠줌
        int[] arr = new int[str.length];    // 문자열의 길이만큼 정수 배열 생성
        int b = Integer.parseInt(br.readLine());    // 개수를 구하고자 하는 정수 입력
        int cnt = 0;   // 개수를 세기 위한 변수

        for(int i=0; i<str.length; i++) {   // 배열 str의 크기만큼 반복
            arr[i] = Integer.parseInt(str[i]);   // arr의 i번째 인덱스에 str의 i번째 인덱스를 정수로 변환해서 넣어줌
        }

        for(int i=0; i<arr.length; i++) {     // 배열 arr의 크기만큼 반복
            if(arr[i] == b) {     // arr의 i번째 인덱스가 b와 값이 같다면,
                cnt++;    // cnt를 1씩 증가시킴
            }
        }

        System.out.println(cnt);    // cnt를 출력
    }
}