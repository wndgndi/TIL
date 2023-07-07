import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int a = t/300;
        t = t%300;
        int b = t/60;
        t = t%60;
        int c = t/10;
        t = t%10;

        if(t != 0) {
            bw.write("-1");
        } else {
            bw.write(a + " " + b + " " + c);
        }

        bw.flush();
        bw.close();
    }

}
