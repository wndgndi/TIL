Lv0. 문자열 정렬하기 (2) 문제

영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때, my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.


< 코드 Java >

import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        String answer = my_string.toLowerCase();  // 문자열 소문자로 변환
        answer = Stream.of(answer.split("")).sorted().collect(Collectors.joining());  // 문자열 분리하여 정렬 후, 다시 합침
        return answer;  // answer 반환
    }
}


< 코드 Python >

def solution(my_string):
    answer = "".join(sorted(list(my_string.lower()))) // 소문자 변환 후, 정렬한 후 합침
    return answer
