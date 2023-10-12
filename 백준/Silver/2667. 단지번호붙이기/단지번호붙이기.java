import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static boolean visited[][];
    static int[][] arr;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    cnt = 1;
                    DFS(i, j, n);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        bw.write(list.size() + "\n");

        for(int num : list) {
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void DFS(int x, int y, int n) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int x2 = x + dx[i];
            int y2 = y + dy[i];

            if(x2 >= 0 && y2 >= 0 && x2 < n && y2 < n) {
                if(!visited[x2][y2] && arr[x2][y2] == 1) {
                    cnt++;
                    DFS(x2, y2, n);
                }
            }
        }
    }

}
