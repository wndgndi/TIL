Lv1. 없는 숫자 더하기 문제

0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.


class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i=0; i<=9; i++) {   // 0에서 9까지 반복
           for(int j=0; j<numbers.length; j++) {   // 배열 numbers의 크기만큼 반복
               if(i == numbers[j]) {   // i가 numbers의 j번째 인덱스와 같다면
                   break;   // 반복문을 벗어남
               } else if(j==numbers.length-1 && i != numbers[j]) {    // 반복문 j가 마지막 반복이고 i와 j번째 인덱스가 같지 않다면,
                   answer += i;  // answer에 i를 누적해서 더함
               }
           }
        }
        
        return answer;   // answer를 반환
    }
}



class Solution {
    public int solution(int[] numbers) {
        int answer = 45;   // 1부터 9까지의 합
       
        for(int i : numbers) {   // numbers의 인덱스들만큼 반복
            answer -= i;
        }
        
        return answer;
    }
}