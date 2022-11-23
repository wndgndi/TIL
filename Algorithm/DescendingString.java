Lv1. 문자열 내림차순으로 배치가히 문제풀이

문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.


< 코드 1 >

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] str = s.split("");   // 각 단어들을 분리하여 str의 인덱스에 하나씩 넣어줌
        Arrays.sort(str, Collections.reverseOrder());  // 내림차순으로 정렬
        
        for(int i=0; i<str.length; i++) {   // str의 길이만큼 반복
            sb.append(str[i]);    // str의 i번째 인덱스를 sb에 넣어줌
        }
        answer = sb.toString();   // sb에 담긴 문자열을 answer에 넣어줌
 
        return answer;  // answer를 반환
    }
}
​


< 코드 2 >

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        return Stream.of(s.split(""))  // s를 각 문자로 나눈 스트림 생성
            .sorted(Comparator.reverseOrder())   // 내림차순으로 정렬
            .collect(Collectors.joining());   // 다시 문자열로 합쳐줌
    }
}
​