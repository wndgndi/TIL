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
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int max = -1000000;
        int min = 1000000;

        for(int i=0; i<n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }

            if(arr[i] < min) {
                min = arr[i];
            }
        }

        bw.write(min + " " + max + "\n");
        bw.flush();
        bw.close();
    }

}