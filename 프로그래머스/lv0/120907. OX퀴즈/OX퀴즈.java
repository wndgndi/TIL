import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++) {
            String[] str = quiz[i].split(" ");
            
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[2]);
            String operator = str[1];
            int c = Integer.parseInt(str[4]);
            
            int result = operator.equals("+")?a+b:a-b;
            answer[i] = c==result?"O":"X";
        }
        
        return answer;
    }
}