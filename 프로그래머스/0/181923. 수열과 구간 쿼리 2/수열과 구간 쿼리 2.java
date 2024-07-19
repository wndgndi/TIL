import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++) {
            int min = Integer.MAX_VALUE;
            boolean chk = false;
            
            for(int j = queries[i][0]; j<= queries[i][1]; j++) {
               if(arr[j] > queries[i][2] && arr[j] < min) {
                   answer[i] = arr[j];
                   min = arr[j];
                   chk = true;
               } 
            }
            answer[i] = chk ? min : -1;
        }
        
        return answer;
    }
}