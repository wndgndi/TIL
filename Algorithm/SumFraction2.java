Lv0. 분수의 덧셈 문제풀이 

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int denom = denom1*denom2/gcd(denom1, denom2);
        int common1 = denom/denom1;
        int common2 = denom/denom2;
        
        int numer = numer1*common1 + numer2*common2;
        
        while(gcd(denom, numer) != 1) {
            int tmp = denom;
            denom = denom/gcd(denom,numer);
            numer = numer/gcd(tmp,numer);
        }
        
        answer[0] = numer;
        answer[1] = denom;
                
        return answer;
    }
    
    public static int gcd(int a, int b) {
        if(a%b == 0) {
            return b;
        } else {
            return gcd(b, a%b);
        }
    }
}