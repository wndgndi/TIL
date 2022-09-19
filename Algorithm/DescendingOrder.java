Lv1. 정수 내림차순으로 배치하기 문제

함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
예를들어 n이 118372면 873211을 리턴하면 됩니다.


import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();   // 내림차순 정렬한 문자열을 넣기 위함
        String st = String.valueOf(n);  // n을 문자열로 변환
        String[] str = st.split("");  // str에 한글자씩 담아줌
        
        Arrays.sort(str,Collections.reverseOrder());   // 담긴 값들을 내림차순 정렬
        
        for(int i=0; i<st.length(); i++) {   // 문자열의 길이만큼 반복
            sb.append(str[i]);   // str의 인덱스들을 sb에 합쳐줌
        }
      
        answer = Long.parseLong(sb.toString());   // 합쳐진 문자열을 다시 정수로 변환
        
        return answer;  // answer 반환
    }
}
​
