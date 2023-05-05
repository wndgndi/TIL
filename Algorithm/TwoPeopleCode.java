Lv1. 둘만의 암호 문제풀이

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] str = skip.split("");   // 문자열 한글자씩 분리
        Set<String> set = new HashSet<>(Arrays.asList(str));  // 배열 st을 Set으로 만들어줌
       
        for(int i=0; i<s.length(); i++) {  // s의 길이만큼 반복
            int cnt = 0;   // index만큼의 횟수를 세기 위한 변수
            char ch = s.charAt(i);   // s의 i번 인덱스 글자
            while(true) {   // 계속 바복
                if(cnt == index) {   // cnt가 index와 같아졌다면,
                    break;   // 반복문 탈출
                }
                
                ch = (char)((int)ch+1);  // 다음 알파벳으로 이동
                if(ch > 'z') {  // 'z'를 넘어갈 경우,
                    ch = 'a';   // 다시 'a'로 돌아옴
                }
                
                String tmp = String.valueOf(ch);  // Set에 포함여부를 확인하기 위해 문자열로 변환
                
                if(set.contains(tmp)) {  // set에 tmp가 포함되어 있다면,
                    continue;  // 지나감
                 } else {   // set에 tmp가 포함되어 있지 않다면,
                    cnt++;  // cnt가 1 증가
                 }
             }
              sb.append(ch);  // ch를 sb에 넣어줌
        }
        
        answer = sb.toString();   // sb를 문자열로 만들어줌
        return answer;   // answer 반환
    }
}