Lv1. 신규 아이디 추천 문제

신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.


< 코드 Java >

import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        new_id = new_id.toLowerCase();
        
        for(char c:new_id.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);  // 소문자, 숫자, -, _, . 일 경우, sb에 해당 문자를 넣어줌 
            }
        }
        
        String answer = sb.toString();  // sb에 담긴 문자들을 문자열로 만들어줌
        while(answer.contains("..")) {   // 문자열 answer에 ".."이 포함되어 있다면,
            answer = answer.replace("..", ".");   // ".."을 "."으로 대체한다
        }
        
        if(answer.length() > 0) {   // 문자열 길이가 0보다 크고,
            if(answer.charAt(0) == '.') {   // 0번째 인덱스가 '.' 이라면,
                answer = answer.substring(1, answer.length());  // 0번째 인덱스를 버림
            }
        }
        
        if(answer.length() > 0) {   // 문자열 길이가 0보다 크고,
            if(answer.charAt(answer.length()-1) == '.') {   // 문자열 마지막 인덱스가  '.' 이라면,
                answer = answer.substring(0, answer.length()-1);   // answer의 마지막 인덱스를 버림
            }
        }    
        
        if(answer.length() == 0) {  // 문자열 길이가 0인 경우,
            answer = "a";  // 문자열에 "a"를 넣어줌
        }
        
        if(answer.length() >= 16) {    // 문자열 길이가 16 이상일 경우,
            answer = answer.substring(0, 15);   // 15글자만 남기고 잘라냄 
            if(answer.charAt(answer.length()-1) == '.') {   // 문자열 마지막 인덱스가 '.' 이라면,
                answer = answer.substring(0, answer.length()-1);  // 문자열의 마지막 인덱스를 버림
            }
        }
        
        sb.setLength(0);   // sb 초기화
        sb = new StringBuilder(answer);   // sb에 answer 문자열 넣어줌
        if(sb.length() <= 2) {   // sb의 길이가 2이하인 경우,
            char c = sb.charAt(sb.length()-1);   // sb의 마지막 인덱스 값으 문자 c로 선언, 초기화
            while(sb.length() < 3) {   // sb의 길이가 3이 될 때까지
                sb.append(c);  // 문자 c를 sb에 넣어줌
            }
        }
        
        answer = sb.toString();   // sb의 문자들을 문자열 answer로 넣어줌
        return answer;   // answer를 반환
    }
}
