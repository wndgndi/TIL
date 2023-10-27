import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        loop:
        for(int i=1; i<=b; i++) {
            for(int j=0; j<i; j++) {
                if(list.size() == b) {
                    break loop;
                }
                list.add(i);
            }
        }

        bw.write(list.stream().skip(a-1).limit(b-a+1).mapToInt(i -> i).sum() + "\n");
        bw.flush();
        bw.close();
    }

}
