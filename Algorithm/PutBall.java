10810 문제

도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 또, 1번부터 N번까지 번호가 적혀있는 공을 매우 많이 가지고 있다. 
가장 처음 바구니에는 공이 들어있지 않으며, 바구니에는 공을 1개만 넣을 수 있다.

도현이는 앞으로 M번 공을 넣으려고 한다. 도현이는 한 번 공을 넣을 때, 공을 넣을 바구니 범위를 정하고, 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣는다. 
만약, 바구니에 공이 이미 있는 경우에는 들어있는 공을 빼고, 새로 공을 넣는다. 공을 넣을 바구니는 연속되어 있어야 한다.

공을 어떻게 넣을지가 주어졌을 때, M번 공을 넣은 이후에 각 바구니에 어떤 공이 들어 있는지 구하는 프로그램을 작성하시오.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");  // 입력받은 문자열 공백을 구분자로 나눔
        int N = Integer.parseInt(st[0]);   // 0번째 인덱스값 정수로 변환
        int M = Integer.parseInt(st[1]);   // 1번째 인덱스값 정수로 변환
        int[] arr = new int[N];   // N 크기의 정수 배열 생성

        for(int i=0; i<M; i++) {   // M만큼 반복
            String[] str = br.readLine().split(" ");   // 공백을 구분자로 문자열 나눔
            int basket1 = Integer.parseInt(str[0]);    // 시작 바구니 정수로 변환
            int basket2 = Integer.parseInt(str[1]);    // 마지막 바구니 정수로 변환
            int ball = Integer.parseInt(str[2]);   // 공 번호 정수로 변환

            for(int j=basket1-1; j<basket2; j++) {   // 시작 바구니부터 마지막 바구니만까지 반복
                arr[j] = ball;   // 바구니에 공 번호를 넣어줌
            }
        }
        for(int n:arr) {   // arr의 인덱스값들 넣어서 출력
            bw.write(n + " ");
        }
        bw.flush();
        bw.close();
    }

}