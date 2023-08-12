import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        List<Integer> list = new LinkedList<>();
        int target = priorities[location];
        priorities[location] = 0;
        
        for(int priority:priorities) {
            list.add(priority);
            }
        
        
        while(!list.isEmpty()) {
            int now = list.remove(0);
            int check = 0;
            
            for(int i=0; i<list.size(); i++) {
                if(now == 0) {
                    if(target < list.get(i)) {
                        list.add(now);
                        check = 1;
                        break;
                    }
                } else if(now < target) {
                    list.add(now);
                    check = 1;
                    break;
                } else if(now < list.get(i)) {
                    list.add(now);
                    check = 1;
                    break;
                }
            }
            if(now == 0 && check == 0) return answer;
            if(check == 0) answer++; 
        }
        
        
        return answer;
    }
}