import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());
        long cnt = 1;

        for (long i = n; i > n-3; i--) {
            cnt *= i;
        }

        for(int i=1; i<=3; i++) {
            cnt /= i;
        }

        bw.write(cnt + "\n" + 3);
        bw.flush();
        bw.close();
    }
}
