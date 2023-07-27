import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int n:arr){
            set.add(n);
        }
        
        for(int m:delete_list){
            set.remove(m);
        }
        
        int[] answer = new int[set.size()];
        
        Iterator iter = set.iterator();

        int tmp = 0;
        while(iter.hasNext()) {
            answer[tmp] = (int)iter.next();
            tmp++;
        }

        return answer;
    }
}