class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        
        for(int i=0; i<control.length(); i++) {
            if(control.charAt(i) == 'w') n++;
            else if(control.charAt(i) == 's') n--;
            else if(control.charAt(i) == 'd') n += 10;
            else if(control.charAt(i) == 'a') n -= 10;
        }
        
        answer = n;
        return answer;
    }
}