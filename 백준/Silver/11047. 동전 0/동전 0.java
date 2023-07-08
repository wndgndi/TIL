import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int cnt=0;
        int[] arr = new int[a];

        for(int i= 0; i<a; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=a-1; i>=0; i--) {
            if(b/arr[i] > 0) {
                cnt += b/arr[i];
                b = b%arr[i];
            }
        }
        System.out.println(cnt);
    }
}