import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];
        int b = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0; i<str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == b) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}