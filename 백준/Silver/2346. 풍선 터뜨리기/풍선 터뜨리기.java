import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i=1; i<=n; i++) {
            deque.add(i);
        }

        int cnt = 0;

        while (!deque.isEmpty()) {
            if(cnt == 0) {
                int paper = deque.pollFirst();
                bw.write(paper + " ");
                cnt = arr[paper-1] > 0 ? arr[paper-1] - 1 : arr[paper-1];
            } else if(cnt > 0) {
                deque.add(deque.pollFirst());
                cnt--;
            } else {
                deque.addFirst(deque.pollLast());
                cnt++;
            }
        }
        bw.flush();
        bw.close();
    }
}
