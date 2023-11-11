import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        bw.write(pow(a, b) + "\n");
        bw.flush();
        bw.close();
    }

    public static long pow(long a, long exp) {
        if(exp == 1) {
            return a % c;
        }

        long tmp = pow(a, exp / 2);

        if(exp % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }

        return tmp * tmp % c;
    }

}
