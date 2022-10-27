Lv1. 약수의 개수와 덧셈 문제

두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 
약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.


class Solution {
    public int solution(int left, int right) {    
        int answer = 0;    // 결과값을 받기 위한 변수
        int cnt = 0;   // 약수의 개수를 세기 위한 변수
        
        for(int i = left; i <= right; i++) {   // 두 정수 사이에서 반복
            for(int j=1; j<= i; j++) {   // 1부터 i까지 반복
                if(i%j == 0) {    // 약수일 경우,
                    cnt++;   // cnt를 1씩 증가시킴
                }
            }
            if(cnt % 2 == 0) {    // 약수의 개수가 짝수일 경우,
                answer += i;    //  i 값을 answer에 누적해서 더함
            } else {      // 약수의 개수가 홀수일 경우,
                answer -= i;    // i 값을 answer에 누적해서 빼줌
            }
            cnt = 0;   // 다음 i 값을 위해 cnt를 다시 0으로 초기화
        }     
        return answer;   // answer를 반환해줌
    }
    
}
