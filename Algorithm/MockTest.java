Lv1. 모의고사 문제

수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.


< 코드 Java >

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] a = new int[answers.length];
        int[] b = new int[answers.length];
        int[] c = new int[answers.length];
        int num = 1;
        
        for(int i=0; i<answers.length; i++) {  // answers의 길이만큼 반복
            if(num > 5) {   // num이 5보다 크면,
                num = 1;   // num을 1로 초기화 시켜줌
            }
            a[i] = num;   // a의 i번째 인덱스에 num 값을 할당
            num++;  // num을 1 증가
        }
        
        num = 1;   // num을 1로 초기화
        
        for(int i=0; i<answers.length; i++) {   // answers의 길이만큼 반복
            if(num > 5) {   // num이 5보다 크면,
                num = 1;   // num을 1로 초기화
            }
            if(i%2 == 0) {    // 인덱스 i가 짝수일 경우,
                b[i] = 2;    // b의 i번째 인덱스에 2를 할당 
            } else {     // 인덱스 i가 홀수일 경우,
                if(num == 2) {   // num의 값이 2이면,
                    num = 3;   // num 값에 3을 넣어줌
                }
                b[i] = num;   // b의 i번째 인덱스에 num 값을 넣어줌
                num++;   // num을 1씩 증가
            }
        }
        
        num = 0;
        int[] arr = {3,1,2,4,5};
        int index = 0;
        
        loop:
        for(int i=0; i<answers.length; i++) {   // answers의 길이만큼 반복
            if(num>4) {   // num이 4보다 크면,
                num = 0;   // num을 0으로 초기화
            }
            for(int j=0; j<2; j++) {   // 2번 반복
                if(index+1 > answers.length) {   // index+1이 answers의 길이보다 크면,
                    break loop;   // 다중 반복문을 탈출
                } else {   // index+1이 answers의 길이보다 작거나 같다면,
                    c[index] = arr[num];   // c의 index 인덱스에 arr의 num 인덱스를 넣어줌
                    index++;  // index가 1씩 증가
                }
            }
             num++;   // num이 1씩 증가
        }
            
        int scoreA = 0;
        int scoreB = 0;
        int scoreC = 0;
        
        for(int i=0; i<answers.length; i++) {    // answers의 길이만큼 반복
            if(answers[i] == a[i]) {    // answers의 i번째 인덱스와 a의 i번째 인덱스가 같다면,
                scoreA++;    // scoreA가 1 증가
            } 
            if(answers[i] == b[i]) {   // answers의 i번째 인덱스와 b의 i번째 인덱스가 같다면,
                scoreB++;    // scoreB가 1 증가
            }
            if(answers[i] == c[i]) {    // answers의 i번째 인덱스와 c의 i번째 인덱스가 같다면,
                scoreC++;   // scoreC가 1 증가
            }
        }
        
        int max = Math.max(Math.max(scoreA, scoreB), scoreC);
                
        if(scoreA == max) {  // scoreA가 max와 같다면,
            list.add(1);  // 리스트에 1을 추가
        }
        if(scoreB == max) {   // scoreB가 max와 같다면,
            list.add(2);   // 리스트에 2를 추가
        }
        if(scoreC == max) {   // scoreC가 max와 같다면,
            list.add(3);   // 리스트에 3을 추가
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();  // 리스트를 int 배열로 변환
        return answer;  // answer를 반환
    }
}