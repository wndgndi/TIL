import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry:map.entrySet()) {
            if(entry.getValue() == 1) {
                sb.append(entry.getKey());
            } 
        }
        
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        String answer = String.valueOf(arr);
        return answer;
    }
}