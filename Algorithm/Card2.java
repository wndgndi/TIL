import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());  // 숫자 n을 입력받는다
        for(int i=1; i<=n; i++) {   // n번만큼 반복
            que.add(i);  // 큐에 i를 넣어준다
        }
        while(que.size()!=1) {  // 큐의 크기가 1이 될때까지 반복
            que.poll();  // 큐의 맨 앞 값을 제거
            que.add(que.poll());  //  큐의 맨앞 값을 제거하고 그 값을 다시 큐에 넣어줌
       }
        bw.write(que.poll()+"\n");  // 하나 남은 큐의 값을 출력
        bw.flush();
        bw.close();
    }
}