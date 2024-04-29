import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {  
            if(isValid(s)) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }
                
        return answer;
    }
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
                if(c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                } else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                } else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                    return false;
                } else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
                }
        }
        
        return stack.isEmpty();
    }
}