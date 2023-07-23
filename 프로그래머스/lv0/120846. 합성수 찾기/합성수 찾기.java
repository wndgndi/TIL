import java.util.*;

class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        for(int i=4; i<=n; i++) {
            if(findDivisor(i) >= 3) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public int findDivisor(int n) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                list.add(i);                
                if(n / i != i) {
                    list.add(n/i);
                }
            } 
        }
        
        return list.size();
    }
}