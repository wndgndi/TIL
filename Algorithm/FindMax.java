Lv0. 가장 큰 수 찾기 문제

정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.


< 코드 >

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        answer[0] = list.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        answer[1] = list.indexOf(answer[0]);
        
        return answer;
    }
}