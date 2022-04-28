import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());  //  반복 입력받을 횟수 정수로 변환
        int sum = 0;   // 합을 구하기 위한 변수 sum 


        while(n-- > 0) {   // n이 0보다 클 동안
            int num = Integer.parseInt(br.readLine());   // 정수를 반복 입력받는다.

            if(!stack.isEmpty() && num == 0) {   // 스택이 비어있지 않고 0을 입력받으면
               stack.pop();   // 스택을 pop 한다
            }
            else {stack.push(num);}    // 0이 아닌 정수를 입력받으면 스택에 푸시한다

        }
        for(int total : stack) {  // 스택의 정수들을 total에 하나씩 넣어준다
            sum += total;   // 하나씩 들어가는 total을 sum으로 합을 구한다.
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();

    }
}
