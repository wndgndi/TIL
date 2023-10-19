import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }

        BFS(r);

        for (int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int cnt = 1;
        visited[start] = cnt;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i = list.get(num).size()-1; i >= 0; i--) {
                int next = list.get(num).get(i);
                if (visited[next] == 0) {
                    visited[next] = ++cnt;
                    queue.offer(next);
                }
            }
        }
    }
}
