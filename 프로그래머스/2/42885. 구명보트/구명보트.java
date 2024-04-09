import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        
        while(i <= j) {
            if(people[j] + people[i] <= limit) {
                i++;
            }
            j--;
            answer++;
        }
        
        return answer;
    }
}