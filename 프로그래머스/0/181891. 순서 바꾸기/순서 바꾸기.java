import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        
        for(int i=0; i<n; i++) {
            list.add(list.remove(0));
        }
       
        int[] answer = list.stream().mapToInt(i -> i).toArray();
  
        return answer;
    }
}