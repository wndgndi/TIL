import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(char c:map.keySet()) {
            if(map.get(c) == 1) {
                list.add(c);
            }
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++) { 
            sb.append(list.get(i));
        }
        
        answer = sb.toString();
        
        return answer;
    }
}