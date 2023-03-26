19532 수학은 비대면강의입니다 문제풀이

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

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if ((a * i + b * j == c) && (d * i + e * j == f)) {   // 두 조건을 모두 만족하는 해 구함
                    x = i;  
                    y = j;
                }
            }
        }

        bw.write(x + " " + y);     // x와 y 출력
        bw.flush();
        bw.close();

    }

}
