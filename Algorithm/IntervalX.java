Lv1. x만큼 간격이 있는 n개의 숫자 문제

함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.


class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];     // 길이가 n인 long 배열 생성 및 초기화
        answer[0] = x;   // answer의 0번째 인덱스에 x값을 넣어줌
        
        for(int i=1; i<n; i++) {     // n번만큼 반복
            answer[i] = answer[i-1] + x;     // answer의 i번째 인덱스에 i-1번째 인덱스에 x를 더한 값을 넣어줌
        }
        
        return answer;    // answer를 반환
    }
}