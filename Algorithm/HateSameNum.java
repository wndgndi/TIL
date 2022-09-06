같은 숫자는 싫어 문제

< 문제 설명 >
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

< 제한사항 >
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수


import java.util.*;

public class Solution { 
    public int[] solution(int[] arr) {
        int[] answer = {};   
        List<Integer> res = new ArrayList<>();   // 배열로 생성시 값이 주어지지 않으면 0이 들어감
        int a = 10;   // 0~9 이외의 수를 a의 값으로 함
        
        for(int i=0; i<arr.length; i++) {   // arr의 길이만큼 반복
            if(arr[i] != a) {     // arr의 i번재 인덱스와 a가 일치하지 않으면,
                res.add(arr[i]);   // res에 arr의 i번째 배열을 넣어줌
                a = arr[i];   // a의 값을 arr의 i번째 인덱스로 초기화
            } 
        }
        
        answer = new int[res.size()];    // 배열 anwer의 크기를 res 크기와 동일하게 생성
        for(int i=0; i<res.size(); i++) {    // res의 크기만큼 반복
            answer[i] = res.get(i);   // res의 인덱스들을 answer에 옮겨줌
        }
        return answer;   // 배열 answer을 반환
    }
}
