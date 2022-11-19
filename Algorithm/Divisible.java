Lv1. 나누어 떨어지는 숫자 배열 문제

array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.


< 코드 1>

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;   // answer 배열의 인덱스에 값을 넣어주기 위한 인덱스 변수
        int size = 0;   // 배열 answer의 크기를 구하기 위한 변수
        
        for(int i=0; i<arr.length; i++) {   // arr의 길이만큼 반복
            if(arr[i]%divisor == 0) {    // arr의 i번째 인덱스를 divisor로 나눈 나머지가 0인 경우,
                size++;   // size를 1씩 증가시킴
            }
        }
        
         int[] answer = new int[size];   // 길이가 size인 정수형 배열 answer를 생성 및 초기화
        
        for(int i=0; i<arr.length; i++) {    // arr의 길이만큼 반복
            if(arr[i]%divisor == 0) {    // arr의 i번째 인덱스를 divisor로 나눈 나머지가 0인 경우,
                answer[cnt] = arr[i];   // answer의 cnt번째 인덱스에 arr의 i번째 인덱스 값을 넣어줌
                cnt++;   // cnt를 1씩 증가시킴
            }
        }
        
        if(answer.length != 0) {   // answer의 길이가 0이 아닌 경우,
        Arrays.sort(answer);    // 배열 answer를 오름차순으로 정렬
        } else {   // answer의 길이가 0인 경우,
            answer = new int[1];   // answer의 길이를 1로 초기화
            answer[0] = -1;   // answer의 0번째 인덱스에 -1을 넣어줌
        }        
        
        return answer;   // answer를 반환
    }
}



< 코드 2>

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
       int[] answer = Arrays.stream(arr).filter(factor -> factor%divisor == 0).toArray();
       //  arr의 인덱스를 divisor로 나눈 나머지가 0인 인덱스로 배열을 생성
        if(answer.length == 0) answer = new int[] {-1}; 
        // 배열 answer의 길이가 0인 경우, -1을 가지는 배열로 초기화
        Arrays.sort(answer);   // answer를 오름차순으로 정렬
        
        return answer;  // answer 반환
    }
}
