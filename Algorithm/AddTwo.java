Lv1. 두 개 뽑아서 더하기 문제

정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers) {
    List<Integer> list = new ArrayList<>();
        
        
    for(int i=0; i<numbers.length-1; i++) {   // 배열 numbers 길이-1 만큼 반복
        for(int j=i+1; j<numbers.length; j++) {   // 배열 numbers 길이만큼 반복
            list.add(numbers[i] + numbers[j]);   // 리스트에 numbers의 i번째와 j번째 인덱스 합 넣어줌
        }
    }
    
    int[] answer = list.stream().distinct()   // 리스트를 스트림으로 변환해 중복제거
                 .mapToInt(Integer::intValue).toArray();  // Integer를 int로 변환해 배열로 만듬
        
    Arrays.sort(answer);  //  배열 answer을 오름차순으로 정렬
        
    return answer;    //  answer을 반환
    }
}
​
