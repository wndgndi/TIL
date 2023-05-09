class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int i=0; i<array.length; i++) {
            int check = array[i];
            while(check/10 > 0) {
                if(check % 10 == 7) {
                    answer ++;
                }
                check = check /10;
            }
            
            if(check % 10 == 7) {
                answer++;
            }
        }
        
        return answer;
    }
}