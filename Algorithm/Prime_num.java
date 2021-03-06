1978번 문제풀이

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt=0;

        for(int i=0; i<n; i++) {
            int p = Integer.parseInt(st.nextToken());

            if(p==1) {
                continue;
            }

            if(p==2){
                cnt++;
            }

            for(int j=2; j<p; j++) {
                if(j==p-1){
                    cnt++;
                }

                else if(p%j != 0) {
                    continue;
                }
                else if(p%j == 0) {
                    break;
                }
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }
}