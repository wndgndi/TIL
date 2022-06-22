import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int cnt=1;

        for(int i=1; i<=n; i++) {
            que.add(i);
        }
        while(que.size()!=0) {
            if (cnt==k) {
                if(que.size()==n && n!=1) {
                    sb.append("<" + que.poll() + ", ");
                    cnt = 1;
                }
                else if(n==1) {
                    sb.append("<" + que.poll() + ">");
                }
                else {
                    if (que.size() == 1) {
                        sb.append(que.poll() + ">");
                    } else {
                        sb.append(que.poll() + ", ");
                        cnt = 1;
                    }
                }
            } else {
                que.add(que.poll());
                cnt++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
