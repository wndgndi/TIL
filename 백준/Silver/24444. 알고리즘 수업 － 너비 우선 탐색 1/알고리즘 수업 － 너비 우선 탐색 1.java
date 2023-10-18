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

    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;

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

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        BFS(r);

        for (int i = 1; i <= n; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;
        queue.offer(start);
        visited[start] = cnt++;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for(int i=0; i<list.get(num).size(); i++) {
                int next = list.get(num).get(i);

                if(visited[next] != 0) {
                    continue;
                }
                queue.offer(next);
                visited[next] = cnt++;
            }
        }
    }

}