class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[n + 1];
        arr[1] = 1;
        
        if(n > 1) {
            arr[2] = 2;

            
            for(int i=3; i<=n; i++) {
                arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
            }
        }
        
        return arr[n];
    }
}