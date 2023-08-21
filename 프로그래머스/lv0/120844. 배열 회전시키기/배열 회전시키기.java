import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = Arrays.copyOf(numbers, numbers.length);
        
        for(int i=0; i<numbers.length; i++) {
            if("right".equals(direction)) {
                if(i == answer.length-1) {
                    answer[0] = numbers[numbers.length-1];
                } else {
                    answer[i+1] = numbers[i];
                }
            } else if("left".equals(direction)) {
                if(i == answer.length-1) {
                    answer[answer.length-1] = numbers[0];
                } else {
                    answer[i] = numbers[i+1];
                }
            }
        }
        
        return answer;
    }
}