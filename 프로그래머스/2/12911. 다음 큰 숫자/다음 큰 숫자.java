class Solution {
    public int solution(int n) {
        int answer = 0;
        String binary1 = Integer.toBinaryString(n);
        int cnt1 = 0;
        
        for(char c : binary1.toCharArray()) {
            if(c == '1') {
                cnt1++;
            }
        }
        
        while(true) {
            int cnt2 = 0;
            n++;
            String binary2 = Integer.toBinaryString(n);
            
            for(char c : binary2.toCharArray()) {
                if(c == '1') {
                    cnt2++;
                }
            }
 
            if(cnt1 == cnt2) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}