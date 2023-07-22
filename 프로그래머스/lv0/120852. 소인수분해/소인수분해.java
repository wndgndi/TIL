import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new LinkedHashSet<>();
        int factor = 2;
        
        while(n != 1) {
            if(n % factor == 0) {
                set.add(factor);
                n /= factor;
            } else {
                factor++;
            }
            
        }
        
        return set.stream().mapToInt(i -> i).toArray();
    }
}