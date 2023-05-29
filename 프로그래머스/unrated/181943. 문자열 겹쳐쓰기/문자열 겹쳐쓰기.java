import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] ch = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = s;
        for(int i=0; i<overwrite_string.length(); i++) {
            ch[cnt] = overwrite_string.charAt(i);
            cnt++;
        }
        
        String answer = new String(ch);
        return answer;
    }
}