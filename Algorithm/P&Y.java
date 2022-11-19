Lv1. 문자열 내 p와 y의 개수 문제

대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 
'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.


< 코드 1 >

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcnt = 0;    // p의 개수를 세기 위한 변수
        int ycnt=0;    // y의 개수를 세기 위한 변수
        
        for(int i=0; i<s.length(); i++) {    // s의 길이만큼 반복
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') {     // s의 i번째 알파벳이 'p'나 'P'일 경우,
                pcnt++;   // pcnt를 1씩 증가시킴
            } else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') {     // s의 i번째 알파벳이 'y'나 'Y'일 경우,
                ycnt++;    // ycnt를 1씩 증가시킴
            }
        }
        
        if(pcnt != ycnt) {     // pcnt와 ycnt의 값이 다른 경우,
            answer = false;     //  answer를 false로 해줌
        } 
        
        return answer;   // answer 반환
    }
}



< 코드 2 >

class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();    // 대소문자 상관없으므로 문자열 s를 모두 대문자로 바꿔줌
        
        return s.chars().filter(pcnt -> pcnt == 'P').count() == 
               s.chars().filter(ycnt -> ycnt == 'Y').count();
         // 문자열 s의 문자 중 P의 개수와 Y의 개수가 같으면 true 반환, 아니면 false 반환
    }
}
