import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 1000 - Integer.parseInt(br.readLine());
        int[] arr = {500, 100, 50, 10, 5, 1};
        int cnt = 0;

        for(int i=0; i<6; i++) {
            cnt += n/arr[i];
            n = n%arr[i];
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

}
