import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        List<String> list = new ArrayList(Arrays.asList(str_list));
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals("l")) {
                list = list.subList(0,i);
                answer = list.stream().toArray(String[]::new);
                break;
            } else if(list.get(i).equals("r")) {
                list = list.subList(i+1,list.size());
                answer = list.stream().toArray(String[]::new);
                break;
            }
        }
        
        return answer;
    }
}