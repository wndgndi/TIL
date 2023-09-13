import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> line = new LinkedList<>();
        Stack<Integer> tmp = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            line.add(Integer.parseInt(st.nextToken()));
        }

        int num = 1;

        while (!line.isEmpty()) {
            if(line.peek() == num) {
                num = line.remove() + 1;
            } else if(!tmp.isEmpty() && tmp.peek() == num) {
                num = tmp.pop() + 1;
            } else {
                tmp.add(line.remove());
            }
        }

        int size = tmp.size();

        for(int i=0; i<size; i++) {
            if(tmp.peek() == num) {
                num = tmp.pop() + 1;
            }
        }

        if(tmp.isEmpty()) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }
        bw.flush();
        bw.close();
    }

}
