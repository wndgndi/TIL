import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String tmp = "";
        String[] str = A.split("");
        
        for(int i=0; i<str.length; i++) {
            if(A.equals(B)) {
                break;
            } else {
                tmp = str[0];
                str[0] = str[str.length-1];
                for(int j=str.length-2; j>=0; j--) {
                    str[j+1]= str[j];
                }
                str[1] = tmp;
                answer++;
            }
            A = String.join("", str);
        }
        
        if(answer == A.length()) {
            answer = -1;
        }
        
        return answer;
    }
}