import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();
        String str = br.readLine();    // 문자열 str을 읽는다.
        char[] arr = str.toCharArray();  // 문자열 str을 char로 하나씩 배열 arr에 넣어준다.
        int total = 0;

        for (int i = 0; i < arr.length; i++) {  // arr 배열의 길이만큼 반복
            char s = arr[i];   // arr 배열의 i번째 인덱스에 들어있는 문자 s

            if (s == '(') {     // 배열에 들어가는게 '(' 일 때,
                stack.push("(");  // 스택을 push한다.
            } else if (s == ')') {    // 배열에 들어가는게 '('일 경우,
                stack.pop();   // 스택을 pop한다.
                if (arr[i - 1] == ')') {   // ')'가 연속으로 나오는 경우,
                    total++;    // total에 1을 더한다.
                } else {   // ')'가 연속으로 들어가지 않는 경우,
                    total += stack.size();   // 스택의 size를 total에 더한다.

                }
            }
        }
        System.out.println(total);

    }
}



문제를 어떻게 풀지 감이 잘 잡히지 않았으나, 아래와 같은 규칙을 알고 코드를 작성해본다면 어려운 문제는 아니다.

'(' 가 나올 때는 스택을 push해서 사이즈를 1씩 증가시켜주고, ')'이 나오면 스택사이즈만큼 변수 Total에 pop 해준다. 
만약,  ')'가 연속으로 나온다면 스택은 pop하여 사이즈는 1을 줄여주고 total에 1을 더해준다.