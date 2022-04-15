import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // 반복할 횟수만큼 문자로 받아 숫자로 변환
		Stack stack = new Stack();  // 스택을 사용하기 위해 스택 생성
		String input = "";     

		for (int i = 0; i < n; i++) {
			input = br.readLine()+"\n";  // 뒤집기 위한 문자열을 입력받고 개행을 더한다.
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == ' ' || input.charAt(j) == '\n') {
					while (!stack.isEmpty()) {   // 스택이 비어있지 않으면 비울 때까지 
						sb.append(stack.pop());   // 스택 데이터를 모두 출력하고 비움
					}
					sb.append(" "); // 거꾸로 단어 출력한 뒤 공백을 더해서 단어 구분지어줌
					} else {
						stack.push(input.charAt(j));  // 공백이나 개행이 아닐 경우 단어를 스택에 push 해줌
					}
				}
			bw.write(sb.toString() + "\n");  // StringBuilder sb에 저장해놨던 뒤집힌 단어 출력
		}
		bw.flush();
		bw.close();
	}

}


input = br.readLine()+"\n"; 에서 개행을 더하는 이유는 \n을 더하지 않으면 마지막 단어가 끝난 뒤에

while(!stack.isEmpty)를 통해 그 단어를 거꾸로 출력할 수 없다.

왜냐하면 while문 바로 위의 if문에서 단어가 끝나는 걸 알리는 기준이 공백 혹은 개행이기 때문이다.
