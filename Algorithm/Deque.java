import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());  // 읽어온 문자열을 정수 n으로 변환
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {       // n이 0보다 클 때까지 반복
            String[] command = br.readLine().split(" ");  // 공백을 기준으로 문자열 분리
            String order = command[0];  // 분리한 command의 0번 인덱스를 변수 order에 넣음

            if(order.equals("push_front")) {    // order가 push_front와 일치할 때
                deque.addFirst(Integer.parseInt(command[1]));  // command의 1번 인덱스는 정수
            }
            else if(order.equals(("push_back"))) {  // order가 push_back과 일치할 때
                deque.addLast(Integer.parseInt(command[1]));
            }
            else if(order.equals("pop_front")) {  // order가 pop_front와 일치할 때
               if(!deque.isEmpty()) {   // 덱이 비어있지 않다면, 
                   sb.append(deque.removeFirst()).append("\n");  // sb에 더해주고 덱에서 지움
               } else {    // 덱이 비어있을 경우,
                   sb.append(-1).append("\n");  // -1을 sb에 더해줌
               }
            }
            else if(order.equals("pop_back")) {     // order가 pop_back과 일치할 때
               if(!deque.isEmpty()){      // 덱이 비어있지 않다면,
                   sb.append(deque.removeLast()).append("\n"); // 덱의 마지막을 sb에 더해주고 지움
               } else {   // 덱이 비어있을 경우,
                   sb.append(-1).append("\n");   // -1을 sb에 더해줌
               }
            }

            else if(order.equals("size")){  // order가 size와 일치할 때
              sb.append(deque.size()).append("\n");  // 덱의 사이즈를 sb에 더해줌
            }
            else if(order.equals("empty")) {  // order가 empty와 일치할 때
                if(deque.isEmpty()) {    // 덱이 비어있는 경우,
                    sb.append(1).append("\n");   // 1을 sb에 더해줌
                } else{    // 덱이 비어있지 않을 경우,
                    sb.append(0).append("\n");   // 0을 sb에 더해줌
                }
            }
            else if(order.equals("front")) {  // order가 front와 일치할 때
                if(!deque.isEmpty()) {   // 덱이 비어있지 않다면, 
                    sb.append(deque.peekFirst()).append("\n");    // 덱의 맨앞을 sb에 더해줌
                } else{
                    sb.append(-1).append("\n");  // -1을 sb에 더해줌
                }
            }
            else if(order.equals("back")){   // order가 back과 일치할 때
                if(!deque.isEmpty()) {  // 덱이 비어있지 않다면,
                    sb.append(deque.peekLast()).append("\n");  // 덱의 마지막을 sb에 더해줌
                } else {    // 덱이 비어있을 경우,
                    sb.append(-1).append("\n");   // -1을 sb에 더해줌
                }
            }
        }
        System.out.println(sb);   // sb를 출력해줌
    }
}