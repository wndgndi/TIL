2738번 문제

N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());   
        int n = Integer.parseInt(st.nextToken());

        int[][] a = new int[m][n];  // 크기가 m*n인 2차원 배열 생성
        int[][] b = new int[m][n];  // 크기가 m*n인 2차원 배열 생성

        for(int i=0; i<m; i++) {   // m번 만큼 반복
            st = new StringTokenizer(br.readLine());   // 문자열 입력받음
            for(int j=0; j<n; j++) {    // n번 만큼 반복
                a[i][j] = Integer.parseInt(st.nextToken());    // 다음 토큰이 있으면 인덱스로 사용
            }
        }

        for(int i=0; i<m; i++) {   // m번 만큼 반복
            st = new StringTokenizer(br.readLine());   // 문자열 입력받음
            for(int j=0; j<n; j++) {    // n번 만큼 반복
                b[i][j] = Integer.parseInt(st.nextToken());   // 다음 토큰이 있으면 인덱스로 사용
            }
        }

        for(int i=0; i<m; i++) {     // m번 만큼 반복
            for(int j=0; j<n; j++) {    // n번 만큼 반복
                sb.append(a[i][j] + b[i][j]);    // StringBuilder에 배열 a와 b의 합을 넣어줌
                sb.append(" ");  // 공백도 넣어줌
            }
            sb.append("\n");    // 줄바꿈
        }

        System.out.println(sb.toString());   // StringBuilder sb 출력

    }
}