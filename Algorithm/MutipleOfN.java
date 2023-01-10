Lv0. n의 배수 고르기 문제

정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.


< 코드 Java >

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        answer = Arrays.stream(numlist).filter(i -> i%n == 0).toArray();
        // 배열을 스트림으로 변환 후, n의 배수인 수만 필터링하여 다시 배열로 만들어줌
        return answer;  // answer을 반환
    }
}


< 코드1 Python >

def solution(n, numlist):
    answer = []
    for i in range(len(numlist)):   // numlist의 길이만큼 반복
        if numlist[i]%n == 0:   // n의 배수인 경우,
            answer.append(numlist[i])   // answer에 값을 넣어줌
    return answer   // answer을 반환

    
< 코드2 Python >

def solution(n, numlist):
    answer = [i for i in numlist if i%n ==0]
    return answer