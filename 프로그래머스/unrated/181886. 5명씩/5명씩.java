import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> list = new ArrayList<>();
                
        for(int i=0; i<names.length; i+=5) {
            list.add(names[i]);
        }
        
        String[] answer = list.stream().toArray(String[]::new);
        return answer;
    }
}