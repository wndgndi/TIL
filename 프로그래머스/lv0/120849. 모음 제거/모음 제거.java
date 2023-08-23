class Solution {
    public String solution(String my_string) {
        String answer = my_string.replaceAll("a|e|i|o|u", "");
        return answer;
    }
}