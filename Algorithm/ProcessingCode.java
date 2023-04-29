Lv0. 코드 처리하기 문제

문자열 code가 주어집니다.
code를 앞에서부터 읽으면서 만약 문자가 "1"이면 mode를 바꿉니다. mode에 따라 code를 읽어가면서 문자열 ret을 만들어냅니다.

mode는 0과 1이 있으며, idx를 0 부터 code의 길이 - 1 까지 1씩 키워나가면서 code[idx]의 값에 따라 다음과 같이 행동합니다.

mode가 0일 때
code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 code[idx]를 추가합니다.
code[idx]가 "1"이면 mode를 0에서 1로 바꿉니다.

mode가 1일 때
code[idx]가 "1"이 아니면 idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
code[idx]가 "1"이면 mode를 1에서 0으로 바꿉니다.
문자열 code를 통해 만들어진 문자열 ret를 return 하는 solution 함수를 완성해 주세요.

단, 시작할 때 mode는 0이며, return 하려는 ret가 만약 빈 문자열이라면 대신 "EMPTY"를 return 합니다.


< Java 코드 >

class Solution {
    public String solution(String code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int mode = 0;  // 모드를 변경하기 위한 변수
        
        String[] str = code.split("");   // 문자열을 분리해서 배열로 만들어줌
        
        for(int i=0; i<str.length; i++) {   // str의 길이만큼 반복
            if(str[i].equals("1")) {   // i번 인덱스가 "1"과 같다면,
                mode = 1 - mode;  // 모드를 변경해줌
            } else if(mode == 0 && i % 2 == 0) {   // 모드가 0이고 짝수일 경우,
                sb.append(str[i]);  // i번 인덱스를 sb에 더해줌
            } else if(mode == 1 && i % 2 != 0) {   // 모드가 1이고 홀수일 경우,
                sb.append(str[i]);   // i번 인덱스를 sb에 더해줌
            }
        }   
        
        answer = sb.toString();  // sb를 문자열로 만들어줌
        if(answer.length() == 0) {   // answer이 비어있다면,
            answer = "EMPTY";   // "EMPTY"를 할당
        }
        
        return answer;   // answer를 반환
    }
}
