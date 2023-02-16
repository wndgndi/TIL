Lv1. 체육복 문제

점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.


< 코드 Java >

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);  // 배열 lost를 오름차순 정렬
        Arrays.sort(reserve);   // 배열 reserve를 오름차순 정렬
        
        for(int i=0; i<lost.length; i++) {   // lost의 길이만큼 반복  
            for(int j=0; j<reserve.length; j++) {   // reserve의 길이만큼 반복  
                if(lost[i] == reserve[j]) {   // lost의 i번째 인덱스와 reserve의 j번째 인덱스가 같다면,
                    answer++;   // answer을 1 증가시킴
                    lost[i] = -1;   // lost의 i번째 인덱스에 -1을 넣어줌
                    reserve[j] = -1;   // reserve의 j번째 인덱스에 -1을 넣어줌
                    // lost의 i번째 인덱스와 reserve의 j번째 인덱스를 -1로 해줌으로써 여벌을 빌려줄 수 없음 
                    break;  // 반복문 탈출
                }
            }
        }
        
        for(int i=0; i<lost.length; i++) {  // lost의 길이만큼 반복
            for(int j=0; j<reserve.length; j++) {   // reserve의 길이만큼 반복
                if(lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) {   
                // lost의 i번째 인덱스가 reserve의 j번째 인덱스보다 1만큼 크거나 작다면,
                    reserve[j] = -1;   // reserve의 j번째 인덱스에 -1을 넣어줘서 이미 빌려줬음을 표시
                    answer++;  // answer가 1 증가
                    break;   // 반복문 탈출
                }
            }
        }
           
        return answer;   // answer를 반환
    }
}