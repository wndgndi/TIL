import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]);    
        }
        
        if("right".equals(direction)) {
            list.add(0, list.get(list.size()-1));
            list.remove(list.size()-1);
        } else {
            list.add(list.get(0));
            list.remove(0);
        }

        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}