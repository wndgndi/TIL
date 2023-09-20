import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if(stack.peek() == s.charAt(i)) {
                stack.pop();
            }  
        }

        return stack.isEmpty() ? 1 : 0;
    }
}