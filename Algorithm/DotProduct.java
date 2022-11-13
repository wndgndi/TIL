Lv1. 내적 문제

길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)


class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {   // 배열 a의 크기만큼 반복
            answer += a[i]*b[i];   // answer에 a와 b의 i번째 인덱스의 곱을 누적하여 더함
        }
        
        return answer;   // answer을 반환함
    }
}