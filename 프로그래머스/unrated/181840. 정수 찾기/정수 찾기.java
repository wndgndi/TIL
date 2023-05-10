import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;

        int a = Arrays.stream(num_list).filter(i -> n == i).findFirst().orElse(-1);
              
        if(a != -1) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}