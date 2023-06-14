import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        int multiple = IntStream.range(0, num_list.length).reduce(1,(a,b) -> a*num_list[b]);
        
        return Math.pow(sum,2) > multiple? 1:0;
    }
}