import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int cnt = 0;
        
        Map<Integer, Integer> map = new TreeMap<>();
        int[] arr = new int[3];
        
        for(int i=0; i<rank.length; i++) {
            map.put(rank[i], i);    
        }

        for(int i=1; i<=map.size(); i++) {
            if(cnt == 3) {
                break;
            }
            
            if(attendance[map.get(i)] == true) {
                arr[cnt] = map.get(i);   
                cnt++;
            }
        }

        answer = 10000*arr[0] + 100*arr[1] + arr[2];
        
        return answer;
    }
}