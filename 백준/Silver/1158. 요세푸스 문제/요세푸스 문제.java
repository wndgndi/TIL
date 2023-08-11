import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        bw.write("<");

        while(list.size() != 0) {
            cnt = ((cnt + k) - 1) % list.size();
            if(list.size() == 1) {
                bw.write(list.get(cnt) + ">");
                break;
            }
            bw.write(list.get(cnt) + ", ");
            list.remove(cnt);
        }

        bw.flush();
        bw.close();
    }

}
