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
  static int order;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    visited = new int[n + 1];
    order = 1;

    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    for (int i = 1; i < list.size(); i++) {
      Collections.sort(list.get(i));
    }

    bfs(r);

    for (int i = 1; i < visited.length; i++) {
      bw.write(visited[i] + " ");
    }
    bw.flush();
    bw.close();
  }

  public static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visited[v] = order++;

    while (!queue.isEmpty()) {
      int cnt = queue.poll();
      for (int i = 0; i < list.get(cnt).size(); i++) {
        if (visited[list.get(cnt).get(i)] == 0) {
          queue.add(list.get(cnt).get(i));
          visited[list.get(cnt).get(i)] = order++;
        }
      }
    }
  }
}

