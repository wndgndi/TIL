백준 11650번 문제

2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.


< 코드 1 > 

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr= new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine()); 
            arr[i][0] = Integer.parseInt(st.nextToken());  // i행0열에 첫번째 토큰 값 넣어줌
            arr[i][1] = Integer.parseInt(st.nextToken());  // i행1열에 두번째 토큰 값 넣어줌
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0] == b[0]) {    // i행0열과 i+1행0열이 같다면,
                return a[1] - b[1];  // i행1열과 i+1행1열을 기준으로 반환
            } else {   // i행0열과 i+1행0열이 다르면,
                return a[0]-b[0];    // i행0열과 i+1행0열을 기준으로 반환
            }
        });

        for(int i=0; i<n; i++) {    //  n번만큼 반복
            bw.write(arr[i][0] + " " + arr[i][1] + "\n"); 
        }
        bw.flush();
        bw.close();
    }
}



< 코드 2 >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr= new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        for(int i=0; i<n; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
​