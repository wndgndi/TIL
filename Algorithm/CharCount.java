Lv0. 문자 개수 세기 문제

알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때, 
my_string에서 'A'의 개수, my_string에서 'B'의 개수,..., my_string에서 'Z'의 개수, my_string에서 'a'의 개수, my_string에서 'b'의 개수,..., 
my_string에서 'z'의 개수를 순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.


< Java 코드 >

class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];  // 알파벳 대,소문자 개수 52개
        
        for(int i=0; i<my_string.length(); i++) {   // 문자열 길이만큼 반복
            int n = (int) my_string.charAt(i);   // 문자를 정수로 변환
            if(n >= 65 && n <= 90) {   // 대문자일 경우,
                answer[n-65] += 1;   // 해당 문자 인덱스값 1 증가
            } else if(n >= 97 && n <= 122) {   // 소문자일 경우,
                answer[n-71] += 1;   // 해당 문자 인덱스 값 1 증가
            }            
        }
        return answer;   // answer를 반환
    }
}