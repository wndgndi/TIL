import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> deque = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int size = Integer.parseInt(st.nextToken());
        int poll = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i=1; i<=size; i++) {
            deque.add(i);
        }

        int[] nums = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();

        for (int num : nums) {
            queue.add(num);
        }

        while (queue.size() != 0) {
            int idx = deque.indexOf(queue.peek());
            size = deque.size() % 2 == 0? deque.size()/2-1 : deque.size()/2;

            if(!Objects.equals(deque.peek(), queue.peek())) {
                if (idx > size) {
                    deque.addFirst(deque.pollLast());
                } else {
                    deque.addLast(deque.pollFirst());
                }
                cnt++;
            } else {
                deque.pollFirst();
                queue.poll();
            }
        }


        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

}
