import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int s1 = 0;
        int s2 = 0;
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if('S' == park[i].charAt(j)) {
                    s1 = i;
                    s2 = j;
                    break;
                } 
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            StringTokenizer st = new StringTokenizer(routes[i]);
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            
            if("E".equals(direction)) {
                if(s2 + distance > park[s1].length()-1) {
                    continue;
                } 
                
                for(int j=s2+1; j <= s2 + distance; j++) {
                    if(park[s1].charAt(j) == 'X') {
                        break;
                    } else if(j == s2 + distance && park[s1].charAt(j) != 'X') {
                        s2 += distance;
                        break;
                    }
                }
            } else if("W".equals(direction)) {
                if(s2 - distance < 0) {
                    continue;
                } 
                
                for(int j=s2-1; j >= s2 - distance; j--) {
                    if(park[s1].charAt(j) == 'X') {
                        break;
                    } else if(j == s2 - distance && park[s1].charAt(j) != 'X') {
                        s2 -= distance;
                        break;
                    }
                }         
            } else if("S".equals(direction)) {
                if(s1 + distance > park.length-1) {
                    continue;
                } 
                
                for(int j=s1+1; j <= s1 + distance; j++) {
                    if(park[j].charAt(s2) == 'X') {
                        break;
                    } else if(j == s1 + distance && park[j].charAt(s2) != 'X') {
                        s1 += distance;
                        break;
                    }
                }
                
            } else if("N".equals(direction)) {
                if(s1 - distance < 0) {
                    continue;
                } 
                
                for(int j=s1-1; j >= s1 - distance; j--) {
                    if(park[j].charAt(s2) == 'X') {
                        break;
                    } else if(j == s1 - distance && park[j].charAt(s2) != 'X') {
                        s1 -= distance;
                        break;
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = s1;
        answer[1] = s2;
        
        return answer;
    }
    
}