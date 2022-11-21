Lv1. 문자열 내 마음대로 정렬하기 문제

문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.


< 코드 1 >

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];  // 배열 strings 길이 만큼의 문자열 배열 answer 생성 및 초기화
        List<String> arr = new ArrayList<>();  
        
        for(int i=0; i<strings.length; i++) {     // 배열 strings의 길이만큼 반복
            arr.add(strings[i].charAt(n) + strings[i]);     
         // arr에 strings i번째 문자열의 n번째 글자와 strings i번째 문자열 합쳐서 넣어줌 
        }
        
        Collections.sort(arr);   // arr 오름차순 정렬
        
        for(int i=0; i<arr.size(); i++) {    // arr의 크기만큼 반복
            answer[i] = arr.get(i).substring(1,arr.get(i).length());    // arr의 i번째 문자열을 꺼내서 1번째 인덱스부터 마지막 글자까지 잘라줌
        }
        
        return answer;   // answer를 반환
    }
}


< 코드 2>

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {   // 새로 정의한 Comparator로 정렬
        
        @Override
        public int compare(String s1, String s2) {
            if(s1.charAt(n) > s2.charAt(n)) return 1;   // 만약 s1의 n번째 글자가 s2의 n번째 글자보다 크다면 1을 반환
            else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);   // 만약 s1과 s2의 n번째 글자가 같다면 s1과 s2의 문자열을 비교해줌 
            else if(s1.charAt(n) < s2.charAt(n)) return -1;   // 만약 s1의 n번째 글자가 s2의 n번째 글자보다 작다면 -1을 반환
            else return 0;   // 그 외의 경우에는 0을 반환
            }
        });
        return strings;   // strings 반환
        
    }
}