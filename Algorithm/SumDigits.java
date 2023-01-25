Lv0. 자릿수 더하기 문제

정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요


< 코드 Java >

import java.util.*;

class Solution {
    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
   // 정수를 문자열로 변환 후, 각 자리를 나누어 다시 정수로 변환하여 더해줌
   }
}


< 코드 Python >

def solution(n):
    return sum(map(int,list(str(n))))
// n을 문자열로 변환 후, 리스트로 만든 값을 다시 정수로 변환하여 더해줌