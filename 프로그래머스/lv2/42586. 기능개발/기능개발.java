import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        
        for(int i=0; i<progresses.length; i++) {
            cnt = 0;

            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                cnt++;
            }
            queue.add(cnt);
        }
        
        int size = queue.size();
        int deploy = queue.poll();
        cnt = 1;
        
        for(int i=1; i<size; i++) {
            if(queue.peek() <= deploy) {
                queue.poll();
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                deploy = queue.poll();
            }
            
            if(i == size-1) {
                list.add(cnt);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}