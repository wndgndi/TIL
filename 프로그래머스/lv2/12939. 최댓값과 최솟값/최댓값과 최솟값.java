class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");

        String max = str[0];
        String min = str[0];
        
        for(int i=0; i<str.length; i++) {
            if(Integer.parseInt(str[i]) > Integer.parseInt(max)) {
                max = str[i];
            } else if(Integer.parseInt(str[i]) < Integer.parseInt(min)) {
                min = str[i];
            }
        }
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        String answer = sb.toString();
        return answer;
    }
}