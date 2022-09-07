class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int a = 7;   // 
        int b = 1;
        
        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == 0) {   // 번호가 0일 경우,
                    a--;   // 최고 순위 상승
                    b++;   // 최저 순위 하락
                    break;  // 내부 for문 벗어남
                } else if(lottos[i] == win_nums[j]) {   // 로또 번호가 일치할 경우,
                    a--;   // 최고 순위 상승
                    break;  // 내부 for문 벗어남
                } else if(lottos[i] != win_nums[j]&&j==5) {   // 일치하는 번호가 없는 경우,
                    b++;   // 최저 순위 하락
                }
            }
        }
        if(a == 7) {  // a가 7인 경우,
            a = 6;   // 최저 순위가 6이므로 6으로 해줌
        } 
        if(b == 7) {   // b가 7인 경우,
            b = 6;   // 최저 순위가 6이므로 6으로 해줌
        }
      int[] answer = {a,b};   // answer 배열 인덱스에 값 설정
        
        return answer;   // answer 반환
    }
}