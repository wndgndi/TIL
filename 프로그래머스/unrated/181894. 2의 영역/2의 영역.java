import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
       
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 2) {
                list.add(i);                
            }
        }
        
        if(list.size() == 0) {
            list.add(-1);
        } else {
            int first = list.get(0);
            int last = list.get(list.size()-1);
            
            list.clear();
            
            for(int i=first; i<=last; i++) {
                list.add(arr[i]);
            }
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}