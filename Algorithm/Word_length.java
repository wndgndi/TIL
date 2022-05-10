2743번 문제​

알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.


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