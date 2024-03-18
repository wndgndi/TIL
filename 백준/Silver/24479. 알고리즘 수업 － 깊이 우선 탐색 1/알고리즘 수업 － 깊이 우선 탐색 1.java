import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int[] check;
  static int order;
  static List<List<Integer>> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    check = new int[n+1];

    for(int i=0; i<=n; i++) {
      list.add(new ArrayList<Integer>());
    }

    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list.get(u).add(v);
      list.get(v).add(u);
    }

    for(int i=1; i<list.size(); i++) {
      Collections.sort(list.get(i));
    }

    order = 1;

    dfs(r);

    for(int i=1; i<check.length; i++) {
      bw.write(check[i] + "\n");
    }
    bw.flush();
    bw.close();
  }

  public static void dfs(int v) {
      check[v] = order;

      for(int i=0; i<list.get(v).size(); i++) {
        if(list.get(v).get(i) != 0 && check[list.get(v).get(i)] == 0) {
          order++;
          dfs(list.get(v).get(i));
        }
      }
  }
}