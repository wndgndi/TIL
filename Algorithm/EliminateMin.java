Lv1. 제일 작은 수 제거하기 문제

정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = Arrays.copyOf(arr, arr.length);  // 배열 arr을 복사한 answer 생성
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(answer);  // 배열 answer를 오름차순 정렬
        int min = answer[0];  // 최소값인 answer의 0번째 인덱스를 min 값으로 넣음

        list = Arrays.stream(arr).boxed().collect(Collectors.toList());  // 배열을 리스트로 변환
        list.remove(Integer.valueOf(min));  // 리스트에서 최소값을 제거
        answer = list.stream().mapToInt(i -> i).toArray();   // 리스트를 다시 배열로 변환
        
        if(answer.length == 0) {   // answer의 길이가 0인 경우,
            answer = new int[] {-1};    // 배열에 -1을 채움
        }
        
        return answer;   // answer를 반환
    }
}
