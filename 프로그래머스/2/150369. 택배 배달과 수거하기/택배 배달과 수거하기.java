class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        for(int i=deliveries.length-1; i>=0;) {
            if(deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }
            
            measure(deliveries, i, cap);
            measure(pickups, i, cap);
            
            answer += (i + 1) * 2;
        }


        return answer;
    }
        
    private void measure(int[] arr, int idx, int cap) {
        while(idx >= 0) {
            if(arr[idx] <= cap) {
                cap -= arr[idx];
                arr[idx--] = 0;
            } else {
                arr[idx] -= cap;
                break;
            }
        }
    }
}