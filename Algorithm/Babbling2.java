Lv1. 옹알이 (2) 문제

머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 
연속해서 같은 발음을 하는 것을 어려워합니다. 
문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.


< 코드 Java >

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++) {  // babbling의 길이만큼 바복
            String str = babbling[i];  // babbling의 i번 인덱스 값을 문자열 str로 넣어줌
            if(str.contains("ayaaya") || str.contains("yeye") 
               || str.contains("woowoo") || str.contains("mama")) {
                continue;  // 문자열에 발음이 연속 두번 포함되어 있으면 건너뜀
            } 
            str = str.replace("aya", "1");   // 문자열 "aya"를 "1"로 바꿔줌
            str = str.replace("ye", "1");   // 문자열 "ye"를 "1"로 바꿔줌
            str = str.replace("woo", "1");  // 문자열 "woo"를 "1"로 바꿔줌
            str = str.replace("ma", "1");   // 문자열 "ma"를 "1"로 바꿔줌
            
            String[] st = str.split("1");   // "1"을 구분자로 문자열 나눔
            if(st.length == 0) {   // 배열 st의 길이가 0이면,
                answer++;   // answer을 1 증가시킴
            }
        }
        
        return answer;   // answer를 반환
    }
}
