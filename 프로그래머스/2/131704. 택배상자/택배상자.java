import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        Queue<Integer> yj = new LinkedList<>();
        List<Integer> dlvy = new LinkedList<>();
        
        for(int i=1; i<=order.length; i++) {
            yj.add(i);
            dlvy.add(order[i-1]);
        }
            
        int size = dlvy.size();
        
        loop:
        for(int i=0; i<size; i++) {
            while(true) {
                if(!yj.isEmpty()) {
                    if(yj.peek().intValue() == dlvy.get(0)) {
                        yj.poll();
                        dlvy.remove(0);
                        answer++;
                    } else {
                        sub.push(yj.poll());
                    }
                }
                
                if(answer == order.length) {
                    break loop;
                }
                           
                if(!sub.isEmpty()) {
                    if(sub.peek().intValue() != dlvy.get(0)) {
                        break;
                    } else {
                        sub.pop();
                        dlvy.remove(0);
                        answer++;
                    }
                } 
            }
        }                        
            
        return answer;
    }
}