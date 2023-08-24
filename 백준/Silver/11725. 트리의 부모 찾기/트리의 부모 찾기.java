import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        boolean[] isVisited = new boolean[n];
        int[] parentNode = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isVisited[0] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int node:tree.get(cur)) {
                if(!isVisited[node]) {
                    isVisited[node] = true;
                    queue.add(node);
                    parentNode[node] = cur;
                }
            }
        }

        for(int i=1; i<n; i++) {
            bw.write(parentNode[i] + 1 + "\n");
        }
        bw.flush();
        bw.close();

    }

}
