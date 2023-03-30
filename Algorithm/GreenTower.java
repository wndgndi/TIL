24723번 녹색거탑 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());   // 녹색거탑의 높이
        
        bw.write((int)Math.pow(2,n) + "\n");   // 경우의 수는 2의 높이만큼 제곱
        bw.flush();
        bw.close();
    }

}
