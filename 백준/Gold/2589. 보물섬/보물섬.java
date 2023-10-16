import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static boolean[][] visited;
    static int height, width;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new String[height][width];

        for(int i=0; i<height; i++) {
            map[i] = br.readLine().split("");
        }

        int max = -1;

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if("L".equals(map[i][j])) {
                    visited = new boolean[height][width];
                    int cnt = BFS(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    public static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        int max = -1;
        queue.offer(new int[] {x, y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int cnt = cur[2];

            if(max < cnt) {
                max = cnt;
            }

            for(int i=0; i<4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                if(nx >=0 && ny >=0 && nx < height && ny < width) {
                    if(!visited[nx][ny] && "L".equals(map[nx][ny])) {
                        queue.offer(new int[] {nx, ny, cnt+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return max;
    }

}