package baekjoon;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class StackExample {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack stack = new Stack();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			String order = command[0];
			
			if (order.equals("push")) {     // ==은 주소를 비교하는 것이고 equals는 값을 비교하는 것이기 때문에 equals를 사용해야 한다.
				int value = Integer.parseInt(command[1]);   // push는 뒤에 정수가 있지만 pop이나 다른 것들은 정수가 없으므로 push if문 안에 넣어줘야 한다.
				stack.push(value);
			}

			else if (order.equals("pop")) {
				if (stack.empty()) {
					bw.write("-1\n");
				} else {
					bw.write(stack.pop() + "\n");
				}
			}

			else if (order.equals("size")) {
				bw.write(stack.size() + "\n");
			}

			else if (order.equals("empty")) {
				if (stack.empty()) {
					bw.write("1\n");
				} 
				else {
					bw.write("0\n");
				}
			}
			
			else if(order.equals("top")) {				
				if(stack.empty()) {
					bw.write("-1\n");
				}
				else {
					bw.write(stack.peek() +"\n");
				}
				
			}

		}
		
		bw.flush();
		bw.close();
	}

}
