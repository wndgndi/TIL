import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack stack = new Stack();

		int n = Integer.parseInt(br.readLine());
		String str = "";
		
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			boolean check = true;
			
			stack.clear();
			
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == ('(')) {
					stack.push('(');
				}
				else if(!stack.isEmpty() && str.charAt(j) == (')')) {
					stack.pop();
				}			
			
				else if(stack.isEmpty() && str.charAt(j) == (')')) {
					System.out.println("NO");
					check = false;
					break;
				}	
	
			}
				
			if(check != false) {
			if(stack.isEmpty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			}		
		}
	}

}
