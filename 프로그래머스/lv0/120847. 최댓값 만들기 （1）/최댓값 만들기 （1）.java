import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {
        numbers = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        int answer = Arrays.stream(numbers).limit(2).reduce(1, (a, b) -> a * b);
        return answer;
    }
}