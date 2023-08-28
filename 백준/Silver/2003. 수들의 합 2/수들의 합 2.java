import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int cnt = 0;

        for(int i=0; i<n; i++) {
            sum = arr[i];
            if(sum == m) {
                cnt++;
                continue;
            }
            for(int j=i+1; j<n; j++) {
                sum += arr[j];
                if(sum == m) {
                    cnt++;
                    break;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

}
