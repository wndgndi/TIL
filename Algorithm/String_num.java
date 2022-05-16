class Solution {
    public int solution(String s) {
         s = s.replace("zero","0");
        s = s.replace("one","1");
        s = s.replace("two","2");
        s = s.replace("three","3");
        s = s.replace("four","4");
        s = s.replace("five","5");
        s = s.replace("six","6");
        s = s.replace("seven","7");
        s = s.replace("eight","8");
        s = s.replace("nine","9");
        int answer= Integer.parseInt(s);
        return answer;
    }
}



s.replace를 이용하여 문자열을 그 값과 일치하는 정수 형태 문자열로 대체해주고, 정수 형태의 문자열을 정수로 변환해준다. 