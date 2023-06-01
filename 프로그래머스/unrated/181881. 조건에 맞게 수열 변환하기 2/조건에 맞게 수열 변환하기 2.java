class Solution {
    public int solution(int[] arr) {
        int n = 0;
        int cnt = 0;
        
        
        while(true) {
            n = 0;
            for(int i=0; i<arr.length; i++) {
                if(arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    n++;
                } else if(arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] = arr[i] * 2 + 1;    
                    n++;
                }
            }
            if(n == 0) {
                break;
            }
            cnt++;
        }
        
        int answer = cnt;
        return answer;
    }
}