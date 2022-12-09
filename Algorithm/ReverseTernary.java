Lv1. 3진법 뒤집기 문제

자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.


< 코드 1 >

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String tmp = Integer.toString(n,3);   // 10진수 n을 3진수로 변환
        StringBuffer sb = new StringBuffer(tmp);    
        String reversetmp = sb.reverse().toString();  // 문자열 tmp를 뒤집어줌
        
        answer = Integer.parseInt(reversetmp,3);   // reversetmp를 다시 10진수로 변환
        
        return answer;   // answer 반환
    }
}



< 코드 2 >

class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = "";
        
        while(n > 0) {    //  n이 0보다 클 때까지 반복
            tmp = n%3 + tmp;   // n을 3으로 나눈 나머지를 tmp에 더함
            n /= 3;   //  n을 3으로 나눈 값으로 갱신
        }

        StringBuffer sb = new StringBuffer(tmp); 
        String reversetmp = sb.reverse().toString();   // 문자열 tmp 뒤집어줌
        
        answer = Integer.parseInt(reversetmp,3);   // 뒤집은 문자열 3진수에서 10진수로 변환
        
        return answer;    //   answer를 반환
    }
}