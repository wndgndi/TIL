Lv1. 명예의 전당 (1) 문제

"명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다. 
매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다. 
즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다. k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 
출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.

이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 
명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.


< 코드 Jav >

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] board = new int[k];
        int cnt = 0;
        
        for(int i=0; i<score.length; i++) {      // score의 길이만큼 반복
            if(score[i] >= board[k-1]) {   // score의 i번째 인덱스가 board의 가장 마지막 인덱스보다 크거나 같다면,
                board[k-1] = score[i];   // board의 마지막 인덱스는 score의 i번째 인덱스 값이 됨
                Integer[] board2 = Arrays.stream(board).boxed().toArray(Integer[]::new);   // int 배열을 Integer 배열로 변환
                Arrays.sort(board2, Collections.reverseOrder());   //  배열 board2를 내림차순 정렬
                board = Arrays.stream(board2).mapToInt(Integer::intValue).toArray();  // 다시 int형 배열로 변환
            }     
            
            if(cnt < k-1) {   // board의 마지막 인덱스보다 작다면,
                answer[cnt] = board[cnt];  // board의 cnt번째 인덱스 값 넣어줌
            } else {  // board의 마지막 인덱스일 경우,
                answer[cnt] = board[k-1];  // 마지막 인덱스 값을 answer의 cnt번째 인덱스에 넣어줌
            }      
            cnt++;   // cnt가 1씩 증가
        }
        
        return answer;   // answer 반환
    }
}
