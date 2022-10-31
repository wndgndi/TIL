Lv1. 음양 더하기 문제

어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 
실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.


class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<signs.length; i++) {    // 배열의 크기만큼 반복
            
            if(!signs[i]) {       // 배열 signs의 인덱스가 false일 경우,
                absolutes[i] = absolutes[i] * (-1);   // absolutes의 인덱스값을 음수로 바꿈
            }
            
           answer += absolutes[i];    // absolutes의 인덱스값들을 누적해서 더해줌
        }
        
        return answer;    // answer를 반환
    }
}

---

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<signs.length; i++) {
            
          answer += absolutes[i] * (signs[i]?1:-1);
          // signs가 true일 경우, absolutes[i]에 1을 곱하여 누적해서 더해주고,
          // sings가 false일 경우, absolutes[i]에 -1을 곱하여 누적해서 더해줌
        }
        
        return answer;
    }
}