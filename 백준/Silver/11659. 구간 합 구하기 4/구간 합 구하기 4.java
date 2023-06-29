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
        int result = 0;

        int[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        int[] sum = new int[arr.length];
        sum[0] = arr[0];

        for(int i=1; i<arr.length; i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start > 1) {
                result = sum[end - 1] - sum[start - 2];
            } else {
                result = sum[end-1];
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

}