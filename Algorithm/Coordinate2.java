백준 11651번 문제

2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        StringTokenizer st;

        for(int i=0; i<n; i++) {   // n번만큼 반복
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 첫번째 토큰을 i행0열에 넣어줌
            arr[i][1] = Integer.parseInt(st.nextToken());   // 두번째 토큰을 i행1열에 넣어줌
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]) {    // i행1열과 i+1행1열이 같다면,
                return a[0] - b[0];   //  i행0열과 i+1행0열을 통해 정렬
            } else {    //  i행1열과 i+1행1열이 다르면,
                return a[1] - b[1];  //  i행0열과 i+1행0열을 통해 정렬
            }
        });

        for(int i=0; i<n; i++) {    // n번만큼 반복
            bw.write(arr[i][0] + " " + arr[i][1] + "\n"); 
        }

        bw.flush();
        bw.close();
    }
}
