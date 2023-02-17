Lv1. 실패율 문제

슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 
원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.

실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.


< 코드 Java >

import java.util.*;

class Solution {
    public double[] solution(int N, int[] stages) {
        double[] answer = new double[N];
        double user = stages.length;
        double[] fail = new double[N];
        
        for(int i=1; i<=N; i++) {   // N번만큼 반복
            double cnt = 0; 
            for(int j=0; j<stages.length; j++) {    // stages의 길이만큼 반복
                if(stages[j] == i) {   // 만약 stages의 j번째 인덱스와 i의 값이 같다면,
                    cnt++;   // cnt를 1 증가시킴
                }
            }
            if(user == 0) {   // 살아남은 인원이 0인 경우,
                fail[i-1] = 0.0;   // fail의 i-1 인덱스에 0.0을 넣어서 NaN 방지
            } else {  // 살아남은 인원이 0명이 아닌 경우,
            fail[i-1] = cnt/user;    //   fail의 i-1 인덱스에 실패율 넣어줌
            user = user - cnt;    // user는 실패한 유저를 제외한 user로 바꿔줌
            }
        }
        
        Double[] newFail = Arrays.stream(fail.clone()).boxed().toArray(Double[]::new);
        Arrays.sort(newFail, Collections.reverseOrder());   // 배열 newFail을 내림차순 정렬

        for(int i=0; i<newFail.length; i++) {   // newFail 길이만큼 반복 
            for(int j=0; j<fail.length; j++) {   // fail 길이만큼 반복
                if(newFail[i] == fail[j]) {   // newFail의 i번째 인덱스와 fail의 j번째 인덱스가 같으면,
                    answer[i] = j+1;   // answer의 i번째 인덱스에 j+1의 값을 넣어줌
                    fail[j] = -1.0;   // fail의 j번째 인덱스에 -1.0을 넣어서 체크한 라운드 제외
                    break;  // 반복문 타출
                }
            }
        }
     
    return answer;     // answer을 반환
    }
}
