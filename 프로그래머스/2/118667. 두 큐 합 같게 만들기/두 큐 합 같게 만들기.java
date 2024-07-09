import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long a = Arrays.stream(queue1).sum();
        long b = Arrays.stream(queue2).sum();
        long sum = a + b;
        int cnt = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
            
        for (int num : queue1) {
            q1.add(num);
        }
        
        for (int num : queue2) {
            q2.add(num);
        }
        
        if(a == b) {
            return 0;
        }
        
        while(a != b) {
            if(cnt > q1.size() + q2.size() + 1) {
                return -1;
            }
            
            if(a < b)  {
                int n = q2.poll();
                q1.add(n);
                a += n;
                b -= n;
            } else {
                int n = q1.poll();
                q2.add(n);
                b += n;
                a -= n;
            }
            cnt++;
        }
        
        return cnt;
    }
}