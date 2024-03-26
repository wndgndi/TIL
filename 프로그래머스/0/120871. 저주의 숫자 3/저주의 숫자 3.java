class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i=2; i<=n; i++) {
            answer++;
            String str = String.valueOf(answer);

           while(answer % 3 == 0 || str.contains("3")) {
               answer++;
               str = String.valueOf(answer); 

           }
        }
        return answer;
    }
}