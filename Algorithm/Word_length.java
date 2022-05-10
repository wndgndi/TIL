import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();  // 문자열 str을 입력받음

        bw.write(str.length()+"\n");  // str의 길이만큼 출력
        bw.flush();
        bw.close();

    }
}