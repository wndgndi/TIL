import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();  // 모든 문자열을 저장할 StringBuilder
        Stack<String> stack = new Stack<>();  // 뒤집을 문자열을 저장할 Stack


        String str = br.readLine();     // 뒤집을 문자열을 입력받음
        String[] arr = str.split("");   // 문자열을 한글자씩 분리해서 배열 arr에 저장

        for(int i=0; i<str.length(); i++) {   // 문자열 길이만큼 반복
           if(arr[i].equals(" ") ) {    //  arr의 i번재 인덱스가 공백이면
              while(!stack.isEmpty()) {    // 스택이 비워질 때까지 반복
                  sb.append(stack.pop());   //  stack의 문자들을 sb에 넣어준다
              }
              sb.append(" ");   // 마지막에 sb에 공백을 넣어줌
           }

           else if(i==(str.length())-1) {   // i가 문자열 길이-1일 때,
              sb.append(arr[i]);   // sb에 arr의 i번째 인덱스를 넣어준다
               while(!stack.isEmpty()) {    // 스택이 비워질 때까지 반복
                   sb.append(stack.pop());   // stack의 문자들을 sb에 넣어준다
               }
           }

           else if(arr[i].equals("<")) {   // arr의 i번째 인덱스가 "<" 일 경우
               while(!stack.isEmpty()) {   // 스택이 비워질 때까지 반복
                  sb.append(stack.pop());  // stack의 문자들을 sb에 넣어준다
              }
               while(!arr[i].equals(">")) {   // arr의 i번째 인덱스가 ">"일때 까지 반복
                   sb.append(arr[i]);   //  arr의 i번째 인덱스를 sb에 넣어줌
                   i++;  // i에 1을 더하여 다음 문자로 넘어갈 수 있도록 함
               }
               sb.append(">");  // s에 ">"를 넣어준다
           }

           else {   // 뒤집을 문자들일 경우
               stack.add(arr[i]);   // 스택에 arr의 i번째 인덱스를 넣어준다
           }
        }
        bw.write(sb.toString());    // 뒤집은 문자열을 출력한다
        bw.flush();
        bw.close();
    }
}
