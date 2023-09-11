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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        int p1 = 0;
        int p2 = k;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        for (int i = k; i < n; i++) {
            sum = sum + arr[p2++] - arr[p1++];
            max = Math.max(sum, max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}
