import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        BigInteger bigint = new BigInteger(number);
        BigInteger num = new BigInteger("9");
        
        int answer = bigint.remainder(num).intValue();
        return answer;
    }
}