import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] type = br.readLine().split(" ");

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<String> deque = new ArrayDeque<>();

        int idx = 0;
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if("0".equals(type[idx++])) {
               deque.add(str);
            }
        }

        int m = Integer.parseInt(br.readLine());

        String[] insert = br.readLine().split(" ");

        for(int i=0; i<m; i++) {
            deque.addFirst(insert[i]);
            bw.write(deque.pollLast() + " ");
        }

        bw.flush();
        bw.close();

    }
}