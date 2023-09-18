import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        int num = 2;
        int cnt = 1;
        
        for(int i=1; i<words.length; i++) {
            String word = words[i];
            char last = words[i-1].charAt(words[i-1].length()-1);
            
            if(set.contains(word) || last != word.charAt(0)) {
                answer[0] = num;
                answer[1] = cnt;
                break;
            } else {
                set.add(word);
            }
            
            if(num == n) {
                num = 1;
                cnt++;
            } else {
                num++;
            }
        }
        
        
        
        
        System.out.println(set);

        return answer;
    }
}