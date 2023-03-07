백준 10812 문제

도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다. 
바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다. 

도현이는 앞으로 M번 바구니의 순서를 회전시키려고 만들려고 한다. 도현이는 바구니의 순서를 회전시킬 때, 순서를 회전시킬 범위를 정하고, 그 범위 안에서 기준이 될 바구니를 선택한다. 
도현이가 선택한 바구니의 범위가 begin, end이고, 기준이 되는 바구니를 mid라고 했을 때, begin, begin+1, ..., mid-1, mid, mid+1, ..., end-1, end 순서로 되어있는 바구니의 순서를 mid, mid+1, ..., end-1, end, begin, begin+1, ..., mid-1로 바꾸게 된다.

바구니의 순서를 어떻게 회전시킬지 주어졌을 때, M번 바구니의 순서를 회전시킨 다음, 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());  // 문자열 토큰으로 입력받음

        int n = Integer.parseInt(st.nextToken());   // 첫번째 토큰 정수로 변환
        int m = Integer.parseInt(st.nextToken());   // 두번째 토큰 정수로 변환
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {     // n번만큼 반복
            arr[i] = i+1;    // i번 인덱스에 i+1을 넣어줌
        }

        for(int i=0; i<m; i++) {    // m번만큼 반복
            st = new StringTokenizer(br.readLine());   // 문자여 토큰으로 입력받음
            int begin = Integer.parseInt(st.nextToken());  // 첫번재 토큰 정수로 변환
            int end = Integer.parseInt(st.nextToken());    // 두번째 토큰 정수로 변환
            int mid = Integer.parseInt(st.nextToken());   // 세번째 토큰 정수로 변환
            int tmp = 0;   // 임시 저장소 tmp 선언, 초기화

            Queue<Integer> queue = new LinkedList<>();

            for(int j=begin; j<=end; j++) {   // begin부터 end까지 반복
                queue.add(arr[begin-1]);  // 큐에 바구니 바꾸기 전 값 넣어줌
                if (mid <= end) {   // mid가 end보다 작거나 같다면,
                    arr[begin-1] = arr[mid-1];   // begin 자리에 mid 값 넣어줌
                    begin++;   // begin이 1 증가
                    mid++;   // mid가 1 증가
                } else if (mid > end) {   // end에 도달했다면,
                    arr[begin-1] = queue.poll();   // 큐에 넣어둔 begin 값을 넣어줌
                    begin++;   // begin이 1 증가
                }
            }
        }
        for(int i:arr) {   // arr 길이만큼 반복
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}c
