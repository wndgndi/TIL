import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger c = new BigInteger(a);
        BigInteger d = new BigInteger(b);
        String answer = String.valueOf(c.add(d));
        
        return answer;
    }
}