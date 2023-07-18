import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(int i=0; i<picture.length; i++) {
            String[] tmp = picture[i].split("");
            
            for(int j=0; j<picture[i].length(); j++) {
                sb.append(tmp[j].repeat(k));  
            }
            
            for(int j=0; j<k; j++) {
                answer[cnt] = sb.toString();
                cnt++;
            }
            sb.setLength(0);
        }
        
        return answer;
    }
}