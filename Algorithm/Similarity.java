Lv0. 배열의 유사도 문제

두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.


< 코드 Java >

import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for(int i=0; i<s1.length; i++) {    // s1의 길이만큼 반복
            if(Arrays.asList(s2).contains(s1[i]) == true) {    // s1의 i번째 인덱스가 s2에 존재하면,
                answer++;    // answer가 1씩 증가함
            }    
        }
        return answer;    // answer 반환
    }
}


< 코드 Python >

def solution(s1, s2):
    answer = 0
    for i in range(len(s1)):  
        if s1[i] in s2: 
            answer += 1  
    return answer  
