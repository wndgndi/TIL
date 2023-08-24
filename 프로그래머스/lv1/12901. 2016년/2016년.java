import java.time.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        LocalDate date = LocalDate.of(2016, a, b);
        answer = date.getDayOfWeek().toString().substring(0,3);     
        
        return answer;
    }
}