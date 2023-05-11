import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        
        while(cnt<arr.length) {
            if(list.size() == 0) {
                list.add(arr[cnt]);
                cnt++;
            } else if (list.size() != 0 && list.get(list.size()-1) == arr[cnt]) {
                list.remove(list.size()-1);
                cnt++;
            } else if(list.size() != 0 && list.get(list.size()-1) != arr[cnt]) {
                list.add(arr[cnt]);
                cnt++;
            }
        }
        
        if(list.size() == 0) {
            list.add(-1);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}