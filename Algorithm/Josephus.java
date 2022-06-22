11866번 문제

요세푸스 문제는 다음과 같다.
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.


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
