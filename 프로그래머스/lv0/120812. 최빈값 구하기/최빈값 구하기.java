import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(array);
        map.put(array[0], 1);
        
        int cnt = 1;
        int max = 0;
        
        for(int i=1; i<array.length; i++) {
            if(array[i] != array[i-1]) {
                cnt = 0;
            }
            cnt++;
            map.put(array[i], cnt);
        }

        cnt = 1;
                
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                answer = entry.getKey();
                cnt = 1;
            } else if(entry.getValue() == max) {
                cnt++;
            }
        }
        
        if(cnt != 1) {
            answer = -1;
        }
        
        return answer;
    }
}