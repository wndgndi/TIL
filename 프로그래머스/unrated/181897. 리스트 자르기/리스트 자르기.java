import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        if(n == 1) {
            list = list.subList(0,b+1);
        } else if(n==2) {
            list = list.subList(a,list.size());
        } else if(n==3) {
            list = list.subList(a,b+1);
        } else if(n==4) {
            list = list.subList(a,b+1);
            for(int i = 0; i < list.size(); i++) {
                if(i%c != 0) {
                    list.set(i, -1);
                }
            }
            list = list.stream().filter(num -> num != -1).collect(Collectors.toList());
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}