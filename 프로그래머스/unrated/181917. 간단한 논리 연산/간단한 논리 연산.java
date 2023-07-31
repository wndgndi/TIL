class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        
        if(x1 || x2) {
            x1 = true;
        } else {
            x1 = false;
        }
        
        if(x3 || x4) {
            x2 = true;
        } else {
            x2 = false;
        }
        
        if(x1 && x2) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}