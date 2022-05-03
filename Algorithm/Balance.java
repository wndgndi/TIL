import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        
            while (true) {     // true일 동안 무한 반복함
            String str = br.readLine();    //  str 문자열을 입력받음
            char[] arr = str.toCharArray();   // char 타입 배열 arr에 문자열의 문자를 하나씩 담음

            if (arr[0] == '.') {    // arr의 0번 인덱스가 '.' 일 경우 
                break;     // 반복문 탈출
            }

            for (int i = 0; i < str.length(); i++) {     // 문자열 str의 길이만큼 반복
                if (arr[i] == '(') {     // arr의 i번재 인덱스가 '(' 일 경우
                    stack.push('(');    // 스택에 push한다
                } else if (arr[i] == ')') {    // arr의 i번재 인덱스가 ')' 일 경우
                    if (stack.isEmpty()) {   // 스택이 비어있다면
                        stack.push(')');     // 스택에 push한다.
                        break;   // 반복문 탈출
                    } else if(stack.peek() == '[') {    // 스택의 맨 위가 '[' 일 경우 
                        break;    // 반복문 탈출, ( '[ )'와 같은 모양이 되므로 짝을 이루지 못함 )
                    }
                    else {   // 그 외의 다른 경우에는
                        stack.pop();   // 스택을 pop 해준다
                    }
                } else if (arr[i] == '[') {   // arr의 i번재 인덱스가 '[' 일 경우
                    stack.push('[');   // 스택에 push 해준다
                } else if (arr[i] == ']') {    // arr의 i번재 인덱스가 ']' 일 경우
                    if (stack.isEmpty()) {     // 스택이 비어있다면
                       stack.push(']');    // 스택에 push 해준다
                        break;  // 반복문 탈출
                    } else if(stack.peek() == '(') {   // 스택의 맨 위가 '('일 경우 
                        break;  // 반복문 탈출, ( '( ]'와 같은 모양이 되므로 짝을 이루지 못함 )
                    }
                    else {   // 그 외의 다른 경우에는
                        stack.pop();  // 스택을 pop해준다
                    }
                }
            }
            if (stack.isEmpty()) {   // 만약 스택이 비어있다면
                    bw.write("yes" + "\n");   // yes 를 출력해준다
            }
             else {    // 스택이 비어있지 않다면
                bw.write("no" + "\n");  //  no를 출력해준다
            }
            stack.clear();   // 스택을 비워준다
        }
        bw.flush();
        bw.close();
    }
}
