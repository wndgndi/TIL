import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        
        for(int i=0; i<str.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        if(str[0].equals("0")) {
            return "0";
        }
        
        answer = String.join("", str);
        return answer;
    }
}