class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int cnt = -1;
        
        for(int i=0; i<myString.length(); i++) {
            int check = myString.indexOf(pat, i);

            if(cnt != check && check != -1) {
                cnt = check;
                answer++;
            }
        }
        
        return answer;
    }
}