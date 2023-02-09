Lv1. 소수 찾기 문제

1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)


< 코드 Java >

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n+1]; 
        
        prime[0] = true;  // 0은 소수가 아니므로 true
        prime[1] = true;  // 1은 소수가 아니므로 true
        
        for(int i=2; i*i<=n; i++) {     // i*i가 n보다 작거나 같을 때까지 반복     
            if(prime[i] == false) {    // prime의 i번째 인덱스가 false일 경우,
                for(int j=i*i; j<=n; j+=i) {     // n보다 작거나 같을 때까지 i를 더해가며 반복
                    prime[j] = true;  // 소수가 아닐 경우 true로 바꿔줌
                }
            }
        }
        
        for(int i=0; i<prime.length; i++) {    // 배열 prime의 길이만큼 반복
            if(prime[i] == false) {    // prime의 i번째 인덱스가 false일 경우,
                answer++;    // answer에 1씩 더함
            }
        }
        
        return answer;   // answer를 반환
    }
}