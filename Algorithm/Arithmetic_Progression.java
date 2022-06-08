import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt=0;

        if(n>0 && n<100) {
            bw.write(n + "\n");
        }

        else if(n>=100) {
            for(int i=100; i<=n; i++) {
                String str = String.valueOf(i);
                String[] st = str.split("");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                int c = Integer.parseInt(st[2]);

                if((a-b == b-c) || (c-b == b-a)) {
                   cnt++;
               }
            }
            bw.write((cnt+99)+"\n");
        }
        bw.flush();
        bw.close();
    }
}