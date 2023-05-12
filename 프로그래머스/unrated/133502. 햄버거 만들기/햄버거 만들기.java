import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> burger = new ArrayList(List.of(1,2,3,1));
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<ingredient.length; i++) {
            list.add(ingredient[i]);
            
            if(list.size() >= 4) {
                List<Integer> tmp = new ArrayList<>();
                
                tmp.add(list.get(list.size()-4));
                tmp.add(list.get(list.size()-3));
                tmp.add(list.get(list.size()-2));
                tmp.add(list.get(list.size()-1));

                if(tmp.equals(burger)) {
                    answer++;
                    list.remove(list.size()-4);
                    list.remove(list.size()-3);
                    list.remove(list.size()-2);
                    list.remove(list.size()-1);
                }
            }
        }
        

        
        
        return answer;
    }
}