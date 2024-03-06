class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        
        
        String s1 = my_string.substring(0, s);

        sb.append(my_string.substring(s, e+1));
        sb.reverse();
        String s2 = sb.toString();
        sb.setLength(0);
        sb.append(s1).append(s2).append(my_string.substring(e+1, my_string.length()));
        
        return sb.toString();
    }
}