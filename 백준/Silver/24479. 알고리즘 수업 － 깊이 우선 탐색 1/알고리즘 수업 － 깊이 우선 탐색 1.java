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
    static int cnt = 1;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0; i<list.size(); i++) {
            Collections.sort(list.get(i));
        }
        arr[v] = cnt;
        DFS(v);

        for(int i=1; i<arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    public static void DFS(int start) {
        for(int i=0; i<list.get(start).size(); i++) {
            if(list.get(start).get(i) != 0 && arr[list.get(start).get(i)] == 0) {
                arr[list.get(start).get(i)] = ++cnt;
                DFS(list.get(start).get(i));
            }
        }
    }
}