import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v, sum = 0;  // 제곱수와 합계를 담기 위한 변수

        for(int i=0; i<5; i++) {    // 5번 반복
            int n = Integer.parseInt(st.nextToken());   // 입력받은 단어 잘라서 가져옴
            v = n*n;   // 정수 n의 제곱값을 v에 넣어줌
            sum += v;   // v의 합계를 sum에 넣어줌
        }
        bw.write((sum%10)+"\n");   // sum을 10으로 나눈 나머지 출력
        bw.flush();
        bw.close();
    }
}
