Lv1. 최대공약수와 최소공배수 문제

두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.


< 코드 Java >

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];        
        int a = Math.max(m, n);  // m과 n 중 큰 수를 a로 초기화
        int b = Math.min(m, n);  // m과 n 중 작은 수를 b로 초기화
        answer[0] = gcd(a, b);  // gcd에 a,b를 인자로 호출하여 반환된 값이 최대공약수
        answer[1] = a * b / gcd(a, b);   // a*b 를 최대공약수로 나누면 최소공배수
        
        return answer;  // answer를 반환
    }
    
    public int gcd(int a, int b) {
        if(b == 0) {   // b가 0일 경우,
            return a;   // a를 반환
        } else {  // b가 0이 아닐 경우,
            return gcd(b, a%b);   // gcd에 인자로 b와 a%b를 전달하여 재귀호출
        }
    }
}