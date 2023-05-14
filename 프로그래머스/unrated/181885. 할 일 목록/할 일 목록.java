import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<todo_list.length; i++) {
            if(finished[i] == false) {
                list.add(todo_list[i]);
            }
        }
        
        String[] answer = list.stream().toArray(String[]::new);
        return answer;
    }
}