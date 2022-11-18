2587번 문제

어떤 수들이 있을 때, 그 수들을 대표하는 값으로 가장 흔하게 쓰이는 것은 평균이다. 평균은 주어진 모든 수의 합을 수의 개수로 나눈 것이다. 
예를 들어 10, 40, 30, 60, 30의 평균은 (10 + 40 + 30 + 60 + 30) / 5 = 170 / 5 = 34가 된다.

평균 이외의 또 다른 대표값으로 중앙값이라는 것이 있다. 중앙값은 주어진 수를 크기 순서대로 늘어 놓았을 때 가장 중앙에 놓인 값이다. 
예를 들어 10, 40, 30, 60, 30의 경우, 크기 순서대로 늘어 놓으면


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];   // 배열의 크기가 5인 정수형 배열 생성
        int avg = 0;   // 평균값을 구하기 위한 변수
        int sum = 0;   // 합을 구하기 위한 변수

        for(int i=0; i<5; i++) {     // 5번 반복
            int a = Integer.parseInt(br.readLine());     // 입력받은 문자열을 정수로 변환
            arr[i] = a;   // arr의 i번째 인데스에 a 값을 넣어줌
            sum += a;    // a값을 누적하여 더함
        }

        avg = sum / 5;     // 합을 5로 나누어 평균 구함
        Arrays.sort(arr);    // arr을 오름차순으로 정렬

        System.out.println(avg);     // avg 출력
        System.out.println(arr[2]);       // arr의 중앙값인 2번째 인덱스 출력

    }
}