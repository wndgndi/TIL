import java.util.*;

public class Solution { 
    public int[] solution(int[] arr) {
        int[] answer = {}; 
        List<Integer> res = new ArrayList<>();
        int a = 10;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != a) {
                res.add(arr[i]);
                a = arr[i];
            } 
        }
        
        answer = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            answer[i] = res.get(i); 
        }
      
        return answer;
    }
}