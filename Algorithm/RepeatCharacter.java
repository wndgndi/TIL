Lv0. 문자 반복 출력하기 문제풀이

class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");   // 문자열 분리해서 배열로 만듦
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length; i++) {  // str 길이만큼 반복
            sb.append(str[i].repeat(n));   // sb에 str의 i번 인덱스 n번 반복해서 넣어줌
        }
        
        answer = sb.toString();   // sb를 문자열로 만듦
        return answer;  // answre 반환
    }
}
