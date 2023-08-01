import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> dices = new HashMap<>();
        
        dices.put(a, dices.getOrDefault(a, 0)+1);
        dices.put(b, dices.getOrDefault(b, 0)+1);
        dices.put(c, dices.getOrDefault(c, 0)+1);
        dices.put(d, dices.getOrDefault(d, 0)+1); 
        
        List<Integer> keys = new ArrayList<>(dices.keySet());
        Collections.sort(keys, (d1, d2) -> (dices.get(d2).compareTo(dices.get(d1))));
        
        if(dices.size() == 1) {
            answer = 1111 * keys.get(0);
        } else if(dices.size() == 2) {
            if(dices.get(keys.get(1)) == 1) {
                int p = keys.get(0);
                int q = keys.get(1);
                answer = (int) Math.pow(10 * p + q,2);
            } else {
                int p = keys.get(0);
                int q = keys.get(1);
                answer = (p + q) * Math.abs(p - q);
            }
        } else if(dices.size() == 3) {
            int q = keys.get(1);
            int r = keys.get(2);
            answer = q * r;
        } else {
            answer = Math.min(Math.min(Math.min(a,b),c),d);
        }
        
   
        return answer;
    }
}