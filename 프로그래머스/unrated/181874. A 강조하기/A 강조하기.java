class Solution {
    public String solution(String myString) {
        myString = myString.toLowerCase();
        String answer = myString.replaceAll("a", "A");
        
        return answer;
    }
}