import java.util.*;

public class Solution { 
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length-1]);
        
        for(int i=arr.length-1; i>=0; i--) {
            if(stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}