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
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0; i<n; i++) {
            Collections.sort(list.get(i));
        }

        visited = new int[n+1];
        visited[v] = cnt++;
        DFS(v);

        for(int i=1; i<visited.length; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static void DFS(int start) {
        for(int i=list.get(start).size()-1; i>=0; i--) {
            int num = list.get(start).get(i);
            if(visited[num] == 0) {
                visited[num] = cnt++;
                DFS(num);
            }
        }
    }

}
