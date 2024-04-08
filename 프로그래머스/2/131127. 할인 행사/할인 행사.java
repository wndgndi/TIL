import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        if(check(map, want, number)) {
            answer++;
        }
        
        for(int i = 10; i < discount.length; i++) {
            String out = discount[i-10];
            if(map.get(out) == 1) {
                map.remove(out);
            } else {
                map.put(out, map.get(out) - 1);
            }
            
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            
            if(check(map, want, number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(Map<String, Integer> map, String[] want, int[] number) {
        for(int i = 0; i < want.length; i++) {
            if(map.getOrDefault(want[i], 0) != number[i]) {
                return false;
            }
        }
        return true;
    }
}
