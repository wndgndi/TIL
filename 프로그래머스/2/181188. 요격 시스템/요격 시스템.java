import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]> () {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] - o2[1] == 0) {
                    return o1[0]-o2[0];
                }
                
                return o1[1] - o2[1];
            }
            
        });
        
        int e = targets[0][1];
        answer++;
        
        for(int i=1; i<targets.length; i++) {
            if(targets[i][0] >= e) {
                e = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}