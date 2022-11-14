Lv1. 가운데 글자 가져오기 문제

단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.


class Solution {
    public String solution(String s) {
        String answer = ""; 
        
        if(s.length() % 2 == 0) {   // 글자의 개수가 짝수일 경우,
            answer = s.substring(s.length()/2-1, s.length()/2+1);   // s에서 가운데 두 글자를 잘라줌
        } else {   // 글자의 개수가 홀수인 경우,
            answer = s.substring(s.length()/2, s.length()/2+1);   // s에서 가운데 한 글자를 잘라줌
        }
        
        return answer;    // answer를 반환
    }
}
