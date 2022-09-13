Lv1. 하샤드 수 문제

양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.


class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String str = Integer.toString(x);  // 정수를 문자열로 변환
        int n = str.length();  // n을 str의 길이값으로 초기화
        int a = 0;   // a를 선언, 초기화
        int b = x;  // 자릿수의 합을 구하기 위해 b에게 x값 부여
        
        for(int i=0; i<n; i++) {   // n만큼 반복
            a += b%10;   // 자릿수를 더하기 위해 10으로 나눈 나머지를 누적해서 더해줌
            b = b/10;  // 이미 계산한 자릿수는 없애줌
        }
        if(x%a != 0) {   // x가 a로 나누어 떨어지지 않으면
            answer = false;  // answer을 false가 됨
        }
        
        return answer;   // answer를 반환
    }
}
