Lv1. 문자열 다루기 기본 문제

문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.


< 코드 1 >

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() == 4 || s.length() == 6) {     // 문자열 s의 길이가 4나 6이면,
            answer = true;   // answer은 true가 됨 
        } else {      // 문자열 s의 길이가 4나 6이 아니라면,
            answer = false;   // answer은 false가 됨
        }
        
        for(int i=0; i<s.length(); i++) {    // s의 길이만큼 반복
            if(!(Character.getNumericValue(s.charAt(i)) >= 0 
                   && Character.getNumericValue(s.charAt(i)) <= 9)) {   
            // 문자를 정수로 변환했을 때 0보다 크거나 9보다 작지 않다면,    
                 answer = false;   // answer은 false가 됨
            }
        }
        return answer;   // answer을 반환
    }

}



< 코드 2 >

class Solution {
    public boolean solution(String s) {

        if(s.length() == 4 || s.length() == 6) {   // s의 길이가 4나 6이라면,
            try {  
                int n = Integer.parseInt(s);    // 문자열 s를 정수로 변환
                return true;   // true를 반환
            } catch(NumberFormatException e) {   // 숫자 형태가 아니라서 예외가 발생한다면,
                return false;    // false를 반환
            } 
        } else {    // s의 길이가 4나 6이 아니라면,
            return false;   // false를 반환
        }
    
    }
}