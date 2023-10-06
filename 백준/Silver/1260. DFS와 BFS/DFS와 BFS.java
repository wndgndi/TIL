import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];


        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        visited = new boolean[n+1];
        dfs(v);

        System.out.println();

        visited = new boolean[n+1];
        bfs(v);
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int i=1; i<arr.length; i++) {
            if(arr[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int n = queue.poll();

            for(int i=1; i<arr.length; i++) {
                if(arr[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
