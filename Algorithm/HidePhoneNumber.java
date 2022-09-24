Lv1. 핸드폰 번호 가리기 문제

프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.


class Solution {
    public String solution(String phone_number) {
        String answer = "";   // 정답을 받기 위한 문자열
        StringBuilder sb = new StringBuilder();  // 문자열을 합치기 위한 StringBuilder
        
        for(int i=0; i<phone_number.length()-4; i++) {   // 뒷자리 4개 이전까지 반복
             sb.append("*");   // 모두 "*" 로 Stringbuilder에 집어넣어줌
        }
      
        sb.append(phone_number.substring(phone_number.length()-4, phone_number.length()));
        //  나머지 뒷자리 4개는 StringBuilder에 정수로 넣어줌      
 
        answer = sb.toString();   // 문자열 answer에 sb의 문자열을 넣어줌
        return answer;   // answer을 반환
    }
}