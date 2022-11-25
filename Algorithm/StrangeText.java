Lv1. 이상한 문자 만들기 문제풀이

문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.


class Solution {
    public String solution(String s) {
        String[] str = s.split("");    // 각 문자들을 나누어 줌
        StringBuilder sb = new StringBuilder();  
        int cnt = 0;
        
        for(int i=0; i<str.length; i++) {   // 배열 str의 길이만큼 반복
            if(str[i].equals(" ")) {      // str의 i번째 인덱스가 공백이라면,
                sb.append(" ");    // sb에 공백을 넣어줌
                cnt=0;   // cnt를 0으로 초기화
            }else {    // str의  i번째 인덱스가 공백이 아니라면,
                if(cnt % 2 == 0) {    // cnt를 2로 나눈 나머지가 0일 때,
                    sb.append(str[i].toUpperCase());   // sb에 str의 i번째 인덱스를 대문자로 넣어줌
                } else {    // cnt를 2로 나눈 나머지가 0이 아닐 때,
                    sb.append(str[i].toLowerCase());    // sb에 str의 i번재 인덱스를 소문자로 넣어줌
                }
                cnt++;   //  cnt가 1씩 증가
            }
        }
        
        return sb.toString();    // sb를 반환
    }
}
