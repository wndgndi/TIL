import java.time.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        LocalDate date = LocalDate.of(2016, a, b);
        String day = date.getDayOfWeek().toString();
        
        answer = day.substring(0,3).toUpperCase();
        
        return answer;
    }
}