import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = my_string.chars()
            .filter(ch -> !Character.isLetter(ch))
            .mapToObj(ch -> Character.getNumericValue(ch))
            .sorted()
            .collect(Collectors.toList());
        
        int[] answer = list.stream().mapToInt(i ->i).toArray();
        return answer;
    }
}