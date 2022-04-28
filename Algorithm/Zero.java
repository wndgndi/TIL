import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());  
        int sum = 0;   
            int num = Integer.parseInt(br.readLine());   

            if(!stack.isEmpty() && num == 0) {  
               stack.pop();  
            }
            else {stack.push(num);}    

        }
        for(int total : stack) { 
            sum += total;  
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();

    }
}



﻿
숫자를 입력받아 0이 아니면 스택에 하나씩 push 해주고, 0을 입력받으면 스택을 pop 해준다.
그리고 마지막에 스택의 값들을 모두 더해주면 되는 간단한 문제이다.

﻿
