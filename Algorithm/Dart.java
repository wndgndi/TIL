Lv1. 다트 게임 문제

카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

1. 다트 게임은 총 3번의 기회로 구성된다.
2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
7.스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.

0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.


< 코드 Java >

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int cnt = 0;
        int[] score = new int[3];
        String str = "";
        int num = 0;

        for(int i=0; i<dartResult.length(); i++) {  // dartResult 문자열 길이만큼 반복
            char c = dartResult.charAt(i);   // 문자열의 i번째 인덱스 문자를 c에 넣어줌
            if(c >= '0' && c <= '9') {   // c가 숫자라면,
                str += c;   // 문자열 str에 문자들을 합쳐줌 (10은 두 자리 수이므로 합쳐줌)
                num = Integer.parseInt(str);   // 문자열을 정수로 변환
            } else if(c == 'S') {   // 문자 c가 'S'일 경우,
                score[cnt] = num;   // score의 cnt번 인덱스에 num을 넣어줌
                str = "";  // str을 빈 문자열로 초기화
                cnt++;   // cnt가 1 증가
            } else if(c == 'D') {   // 문자 c가 'D'일 경우.
                score[cnt] = (int) Math.pow(num, 2);   // score의 cnt번 인덱스에 num의 제곱값 넣어줌
                str = "";   // str을 빈 문자열로 초기화
                cnt++;   // cnt가 1 증가
            } else if(c == 'T') {   // 문자 c가 'T'일 경우,
                score[cnt] = (int) Math.pow(num, 3);   // score의 cnt번 인덱스에 num의 3제곱값을 넣어줌
                str = "";   // str을 빈 문자열로 초기화
                cnt++;   // cnt가 1 증가
            } else if(c == '*') {   // 문자 c가 '*'일 경우,
                score[cnt-1] = score[cnt-1] * 2;   // cnt-1번 인덱스 값에 2를 곱해줌
                if(i != 2) {   // i가 2가 아닐 경우,
                    score[cnt-2] = score[cnt-2] * 2;   // cnt-2번 인덱스 값에 2 곱해줌
                }  // i가 2일 경우는 첫번째 점수만 두배로 만들면 됨
            } else if(c == '#') {  // 문자 c가 '#'일 경우,
                score[cnt-1] = score[cnt-1] * (-1);  // score의 cnt-1번 인덱스 값에 -1을 곱해줌
            }
        }

        for(int n:score) {  // 배열 score의 길이만큼 반복
            answer += n;  // score의 모든 값들을 더해줌
        }
        
        return answer;  // answer를 반환
    }
}