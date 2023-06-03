class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int m = 2 * a * b;
        int n = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        
        return Math.max(n, m);
    }
}