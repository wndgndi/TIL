class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 1;
        int idx = my_string.length() - 1;
        
        if(is_suffix.length() > my_string.length()) {
            return 0;
        }
        
        for(int i=is_suffix.length() - 1; i>=0; i--) {       
            if(my_string.charAt(idx) != is_suffix.charAt(i)) {
                return 0;
            }
            idx--;
        }
        
        return answer;
    }
}