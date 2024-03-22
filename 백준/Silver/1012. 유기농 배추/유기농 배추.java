import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int worm = 0;

      arr = new int[m][n];
      visited = new boolean[m][n];

      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        arr[a][b] = 1;
      }

      for (int j = 0; j < m; j++) {
        for (int l = 0; l < n; l++) {
          if (!visited[j][l] && arr[j][l] == 1) {
            worm++;
            dfs(j, l, m, n);
          }
        }
      }

      bw.write(worm + "\n");

    }
    bw.flush();
    bw.close();

  }

  public static void dfs(int x, int y, int m, int n) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int x2 = x + dx[i];
      int y2 = y + dy[i];

      if (x2 >= 0 && y2 >= 0 && x2 < m && y2 < n) {
        if (!visited[x2][y2] && arr[x2][y2] == 1) {
          dfs(x2, y2, m, n);
        }
      }
    }
  }
}
