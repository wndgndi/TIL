import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if(order == 1) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerFirst(num);
            } else if(order == 2) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
            } else if (order == 3) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.pollFirst() + "\n");
                }
            } else if (order == 4) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.pollLast() + "\n");
                }
            } else if (order == 5) {
                bw.write(deque.size() + "\n");
            } else if (order == 6) {
                if(deque.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if(order == 7) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.peekFirst() + "\n");
                }
            } else if (order == 8) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.peekLast() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }

}
