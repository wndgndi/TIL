Lv0. 배열의 평균값

정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.


< 코드 >

import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        double answer = (double) Arrays.stream(numbers).reduce(0, Integer::sum)/numbers.length;
        
        return answer;
    }
}
    
}
