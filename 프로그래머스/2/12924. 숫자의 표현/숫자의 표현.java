class Solution {
    public int solution(int n) {
        int answer = 0;
        int p1 = 0;
        int p2 = 1;
        int sum = 1;
        
        if(n == 1) return 1;
        
        while(p1 <= p2 && p2 <= n) {
            if(sum < n) {
                p2++;
                sum += p2;
            } else if(sum == n) {
                answer++;
                
                if(p2 < n) {
                    p2++;
                    sum += p2;
                } else if(p2 == n && p1 == p2) {
                    break;
                }
            } else {
                sum -= p1;
                p1++;
            }
        }
        
        return answer;
    }
}