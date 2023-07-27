import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String str = my_string.replaceAll("\\s+", " ");
        String[] answer = str.trim().split(" ");

        return answer;
    }
}