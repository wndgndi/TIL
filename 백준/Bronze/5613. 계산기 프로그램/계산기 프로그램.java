import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        int cnt = 0;
        int num = 0;
        String operator = "";
        int answer = Integer.parseInt(br.readLine());

        while(!"=".equals(str)) {
            str = br.readLine();

            if(cnt % 2 != 0) {
                num = Integer.parseInt(str);

                if("+".equals(operator)) {
                    answer += num;
                } else if("-".equals(operator)) {
                    answer -= num;
                } else if("*".equals(operator)) {
                    answer *= num;
                } else if("/".equals(operator)) {
                    answer /= num;
                }
            } else {
                operator = str;
            }
            cnt++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
