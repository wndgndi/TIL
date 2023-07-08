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
        String seat = br.readLine();
        int tmp = 0;
        int cnt = 0;

        for(int i=0; i<seat.length(); i++) {
            if(seat.charAt(i) == 'S') {
                cnt++;
            } else if(seat.charAt(i) == 'L') {
                tmp++;
                if(tmp == 2) {
                    cnt++;
                    tmp = 0;
                }
            }
        }

        cnt = cnt + 1;

        if(cnt > n) {
            cnt = cnt -1;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

}
