import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while(pq.size() != 1) {
            int min = pq.poll();
            
            if(min >= K) {
                break;
            } else {
                pq.offer(min + pq.poll() * 2);
                answer++;
            }
        }
        
        if(pq.poll() < K) {
            answer = -1;
        }
        
        return answer;
    }
}