import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = 0;
        
        for(int i=0; i<=10; i++) {
            n = (int) Math.pow(2, i);
            if(n >= arr.length) {
                break;
            }
        }
        
        for(int i=0; i<n-arr.length; i++) {
            list.add(0);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}