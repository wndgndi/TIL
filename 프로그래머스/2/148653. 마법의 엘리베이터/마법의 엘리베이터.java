class Solution {         
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int remainder = storey % 10;
            int next = (storey / 10) % 10;

            if(remainder > 5) {           
                storey += 10;
                answer += (10 - remainder);
            } else {
                if(remainder == 5 && next >= 5 && storey >= 10) {
                    answer += 5;
                    storey += 10;
                } else {
                    answer += remainder;
                }
            }

           storey /= 10;
        }
        
        return answer;
    }
}