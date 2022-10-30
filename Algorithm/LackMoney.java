Lv1. 부족한 금액 계산하기

새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 이 놀이기구의 원래 이용료는 price원 인데, 
놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
단, 금액이 부족하지 않으면 0을 return 하세요.


class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;   // 이용료의 총합을 구하기 위한 변수
        
        for(int i=0; i<=count; i++) {    // 이용 횟수만큼 반복 
            sum += price*i;   // 이용료에 이용횟수만큼 곱해서 누적하여 더해줌
        }
        
        if(sum>money) {    // 이용료 총합이 소지금보다 크면,
            answer = sum - money;   // answer은 이용료 총합과 소지금의 차이값이 됨
        } else {   // 이용료 총합이 소지금보다 크지 않으면,
            answer = 0;   // 돈이 부족하지 않으므로 0이 됨
        }
        
        return answer;   // answer을 반환
    }
}