import java.util.*;
// import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(i%2 != 0) {
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
            
        for(int i=0; i< answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
        
//      return IntStream.range(0, n+1).filter(i -> i % 2 == 1).toArray();

    }
}