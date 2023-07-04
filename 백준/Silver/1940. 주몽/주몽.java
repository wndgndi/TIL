import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                            .map(Integer::parseInt)
                            .mapToInt(i -> i).toArray();
        int start = 0;
        int end = n-1;
        int sum = 0;
        int cnt = 0;

        Arrays.sort(arr);

        while(end-start >= 1 ) {
            sum = arr[start] + arr[end];

            if(sum < m) {
                start++;
            } else if(sum == m) {
                cnt++;
                start++;
                end--;
            } else {
                end--;
            }

        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

}