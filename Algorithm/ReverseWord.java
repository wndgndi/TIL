17413번 문제

문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.

    1. 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
    2. 문자열의 시작과 끝은 공백이 아니다.
    3. '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.

태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 
단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.


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
