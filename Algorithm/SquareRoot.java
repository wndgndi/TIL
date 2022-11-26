Lv1. 정수 제곱근 판별 문제

임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.


class Solution {
    public long solution(long n) {
        long answer = 0;
        long a = (long)(Math.sqrt(n));   // n의 제곱근을 구하여 long으로 변환
        
        if(a*a == n) {    // a의 제곱이 n과 같다면,
            answer = (a+1)*(a+1);    // answer은 (a+1)의 제곱이 됨
        } else if(a*a != n) {   // a의 제곱이 n과 다르다면,
            answer = -1;    // answer은 -1이 됨
        }
        
        return answer;     // answer을 반환
    }
}
