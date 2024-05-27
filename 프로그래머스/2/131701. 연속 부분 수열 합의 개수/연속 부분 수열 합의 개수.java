import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<elements.length; i++) {
            int n = 0;
            for(int j=0; j<elements.length; j++) {
                int idx = i + j;
                if(idx >= elements.length) idx -= elements.length;
                
                n =  n + elements[idx];

                set.add(n);
            }
        }
        
        return set.size();
    }
}