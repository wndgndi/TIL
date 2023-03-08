백준 10813 문제

도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 
바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.

도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.

공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {   // n번만큼 반복
            arr[i] = i+1;   // i번 인덱스에 i+1 을 넣어줌
        }

        for(int i=0; i<m; i++) {   // m번만큼 반복
            int tmp = 0; 
            st = new StringTokenizer(br.readLine());   // 문자열 토큰으로 입력받음
            int a = Integer.parseInt(st.nextToken());   // 첫번째 토큰 정수로 변환
            int b = Integer.parseInt(st.nextToken());   // 두번째 토큰 정수로 변환

            tmp = arr[a-1];   // a-1번 인덱스 값 임시로 저장
            arr[a-1] = arr[b-1];   // a-1 인덱스에 b-1 인덱스의 값을 넣어줌
            arr[b-1] = tmp;   // b-1 인덱스에 임시로 저장해둔 값 넣어줌
        }

        for(int i:arr) {   // arr의 길이만큼 반복
            bw.write(i + " "); 
        }
        bw.flush();
        bw.close();
    }
}
​
