import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] numbers = my_string.split("\\D+");
        
        for(int i=0; i<numbers.length; i++) {
            if(!numbers[i].equals("")) {
                answer += Integer.parseInt(numbers[i]);
            }
        }
        
        return answer;
    }
}