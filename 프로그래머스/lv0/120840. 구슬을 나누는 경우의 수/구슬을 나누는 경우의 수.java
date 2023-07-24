import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        return factorial(balls).divide(factorial(balls - share).multiply(factorial(share))).intValue();
    }
    
    public BigInteger factorial(int n) {
        BigInteger cases = BigInteger.ONE;
        
        for(int i=1; i<=n; i++) {
            cases = cases.multiply(BigInteger.valueOf(i));
        }
        
        return cases;
    }
}