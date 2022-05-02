import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<>();


        int n = Integer.parseInt(br.readLine());  // 반복할 횟수 입력, 변환
        int last = 0;  // back을 출력하기 위한 변수

        while(n-- > 0) {   // n번 동안 반복
            String[] str = br.readLine().split(" ");  // 공백을 구분자로 문자열을 분리
            String order = str[0];   // 분리한 문자열의 명령을 order로 사용

            if(order.equals("push")) {    // order가 push일 경우
                last = Integer.parseInt((str[1])); // 분리한 문자열의 정수를 last로 사용
                que.add(last);  // 정수인 last를 큐에 add 해줌
            }

            else if(order.equals("pop")){  // order가 pop일 경우
                if(que.isEmpty()) {   // 큐가 비어있다면
                    bw.write("-1\n");   // -1을 출력
                }
                else{    // 큐가 비어있지 않다면
                    bw.write(que.poll()+"\n");   // 큐를 poll 해줌
                }
            }

            else if(order.equals("size")) {   // order가 size일 경우
                bw.write(que.size()+"\n");     // 큐의 사이즈를 출력
            }

            else if(order.equals("empty")) {   // order가 empty일 경우
                if(que.isEmpty()){      // 큐가 비어있다면
                    bw.write("1\n");    // 1을 출력
                }
                else {   // 큐가 비어있지 않다면
                    bw.write("0\n");    // 0을 출력
                }
            }

            else if(order.equals("front")) {    // order가 front일 경우
                if (que.isEmpty()) {    // 큐가 비어있다면 
                    bw.write("-1\n");   // -1을 출력
                } else {     // 큐가 비어있지 않다면
                    bw.write(que.peek() + "\n");  // 큐를 peek 해줌
                }
            }

            else if(order.equals("back")) {   // order가 back일 경우
                if(que.isEmpty()) {     // 큐가 비어있다면 
                    bw.write("-1\n");    // -1을 출력
                }
                else {      // 큐가 비어있지 않다면
                    bw.write(last + "\n");     // last를 출력
                }
            }
        }
        bw.flush();
        bw.close();
    }
}