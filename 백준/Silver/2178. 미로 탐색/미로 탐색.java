import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static boolean[][] visited;
  static int[][] maze;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int n, m;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    maze = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      maze[i] = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).mapToInt(num -> num)
          .toArray();
    }

    n -= 1;
    m -= 1;

    visited[0][0] = true;
    bfs(0, 0);
    bw.write(maze[n][m] + "\n");
    bw.flush();
    bw.close();
  }


  public static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});

    while(!queue.isEmpty()) {
      int[] arr = queue.poll();

      for(int i=0; i<4; i++) {
        int x2 = arr[0] + dx[i];
        int y2 = arr[1] + dy[i];

        if(x2 >= 0 && y2 >= 0 & x2 <= n && y2 <= m) {
          if(!visited[x2][y2] && maze[x2][y2] != 0) {
            queue.add(new int[]{x2, y2});
            visited[x2][y2] = true;
            maze[x2][y2] = maze[arr[0]][arr[1]] + 1;
          }
        }
      }
    }
  }
}
