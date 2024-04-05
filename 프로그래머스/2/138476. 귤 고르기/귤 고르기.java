import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
          
        for(Map.Entry<Integer, Integer> entry : list) {
            k -= entry.getValue();
            answer++;
            
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}