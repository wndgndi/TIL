import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num:array) {
            int cnt = map.getOrDefault(num,0) + 1;
            if(cnt > max) {
                max = cnt;
                answer = num;
            } else if(cnt == max) {
                answer = -1;
            }
            map.put(num, cnt);
        }
        
        return answer;
    }
}