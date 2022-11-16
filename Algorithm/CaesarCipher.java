Lv1. 시저 암호 문제

어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 
문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.


class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();   // StringBuilder 생성
        char[] arr = s.toCharArray();   // 문자열을 문자로 나눠서 배열에 넣어줌
        
        for(int i=0; i<s.length(); i++) {   // 문자열의 길이만큼 반복
            char ch = arr[i];   // ch는 arr의 i번째 인덱스의 문자
            if((char) ch+n > 'z' || ch < 'a' && (char) ch+n > 'Z') {   
            // ch와 n의 합이 'z' 보다 크거나, ch가 'a'보다 작고 ch와 n의 합이 'Z'보다 큰 경우,
                ch = (char) (ch-26+n);   // ch에서 26만큼 빼주고 n을 더함
                sb.append(ch);   // 문자 ch를 sb에 넣어줌
            } else if(ch == ' ') {   // ch가 공백일 경우,
                sb.append(ch);   // 그대로 sb에 넣어줌
            } else {    // 그 외의 경우 (s는 소문자, 대문자, 공백으로만 이루어져있으므로)
                ch = (char) (ch+n);  // ch와 n을 더함
                sb.append(ch);   // 문자 ch를 sb에 넣어줌
            }
            
        }
              
        return sb.toString();   // sb를 반환해줌
    }
}
