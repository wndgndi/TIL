import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        Arrays.sort(indices);
        
        for(int i=0; i<my_string.length(); i++) {
            if(cnt<=indices.length-1 && i==indices[cnt]) {
                cnt++;
            } else {
                sb.append(my_string.charAt(i));
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}