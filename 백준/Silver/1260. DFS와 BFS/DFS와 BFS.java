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

  static BufferedWriter bw;
  static List<List<Integer>> list = new ArrayList<>();
  static int[] visited;
  static int order = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());
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

    bw.write(v + " ");
    dfs(v);
    bw.write("\n");
    visited = new int[n + 1];
    bw.write(v + " ");
    bfs(v);
    bw.write("\n");

    bw.flush();
    bw.close();
  }

  public static void dfs(int v) throws IOException{
    visited[v] = order;

    for (int i = 0; i < list.get(v).size(); i++) {
      if (visited[list.get(v).get(i)] == 0) {
        bw.write(list.get(v).get(i) + " ");
        dfs(list.get(v).get(i));
      }
    }
  }

  public static void bfs(int v) throws IOException {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    order = 1;
    visited[v] = order;

    while (!queue.isEmpty()) {
      int num = queue.poll();
      for (int i = 0; i < list.get(num).size(); i++) {
        if (visited[list.get(num).get(i)] == 0) {
          visited[list.get(num).get(i)] = ++order;
          queue.add(list.get(num).get(i));
          bw.write(list.get(num).get(i) + " ");
        }
      }
    }
  }
}
