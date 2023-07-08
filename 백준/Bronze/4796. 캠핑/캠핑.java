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

        int cnt = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(l == 0 && p == 0 && v == 0) {
                break;
            }

            int n = v/p;
            int m = v%p;
            int stay = l * n + Math.min(l,m);

            bw.write("Case " + cnt + ": " + stay + "\n");
            cnt++;
        }
        bw.flush();
        bw.close();
    }

}
