import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] arr) {
        String answer = Arrays.stream(arr).collect(Collectors.joining());
        return answer;
    }
}