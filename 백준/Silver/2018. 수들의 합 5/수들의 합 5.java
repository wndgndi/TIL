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
        int start = 1;
        int end = 1;
        int sum = 1;
        int cnt = 1;

        while(start != n) {
            if(sum < n) {
                end += 1;
                sum+= end;
            } else if(sum == n) {
                cnt += 1;
                end += 1;
                sum += end;
            } else {
                sum -= start;
                start += 1;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }
}
