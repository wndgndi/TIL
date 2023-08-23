class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c) {
                continue;
            } else {
                sb.append(c);
            }
        }
        answer = sb.toString();
        return answer;
    }
}