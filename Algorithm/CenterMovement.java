import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());  
        int square = 1;   // 초기 사각형 한개

        for(int i=0; i<n; i++) {    // n번 반복
            square *= 2;    // 과정이 반복될 때마다 사각형 한줄이 두배로 늘어남 
        }

        bw.write((int)Math.pow(square+1, 2) + "\n");  // 점 개수는 사각형 개수보다 1개 많으므로 더하여 제곱
        bw.flush();
        bw.close();
    }

}
