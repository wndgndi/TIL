import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        
        while(idx < arr.length) {
            if(list.size() == 0) {
                list.add(arr[idx]);
                idx++;
            } else {
                if(list.get(list.size() - 1) < arr[idx]) {
                    list.add(arr[idx]);
                    idx++;
                } else {
                    list.remove(list.size() - 1);
                }
            }
        }
        
        int[] stk = list.stream().mapToInt(n -> n).toArray();
        
        return stk;
    }
}