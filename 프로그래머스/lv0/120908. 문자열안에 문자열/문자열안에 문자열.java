class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int idx = 0;
        
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) == str2.charAt(idx)) {
                if(idx == str2.length()-1) {
                    answer = 1;
                    break;
                }
                idx++;
            } else {
                idx = 0;
            }
        }
        
        if(answer == 0) {
            answer = 2;
        }
        
        return answer;
    }
}