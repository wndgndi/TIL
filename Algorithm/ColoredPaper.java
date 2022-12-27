백준 2563번 색종이 문제

가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.


< 코드 >

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

        int n = Integer.parseInt(br.readLine());   // 색종이의 수 입력받음
        boolean[][] arr = new boolean[101][101];
        StringTokenizer st;

        int area = 0;

        for (int i = 0; i < n; i++) {   // n번만큼 반복
            st = new StringTokenizer(br.readLine());   // 토큰 입력받음
            int x = Integer.parseInt(st.nextToken());  // 첫번째 토큰값은 x 좌표 
            int y = Integer.parseInt(st.nextToken());  // 두번재 토큰값은 y 좌표

            for (int j = x; j < x + 10; j++) {   // 색종이 x좌표인 x부터 x+10까지 반복
                for (int k = y; k < y + 10; k++) {  // 색종이 y좌표인 y부터 y+10까지 반복
                    if (arr[j][k] == true) {   // x, y 좌표값이 true인 경우,
                        continue;   // 이미 계산한 면적이므로 지나감
                    } else {   // x, y 좌표값이 false인 경우.
                        arr[j][k] = true;  // 해당 좌표값을 true로 바꿔줌
                        area++;   // area에 1씩 더하여 면적을 구함
                    }

                }
            }
        }
        bw.write(area + "\n");
        bw.flush();
        bw.close();
    }

}