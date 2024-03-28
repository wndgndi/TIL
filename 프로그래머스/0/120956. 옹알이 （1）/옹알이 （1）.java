class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] p = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++) {
            String str = babbling[i];
            for(int j=0; j<p.length; j++) {
                str = str.replace(p[j], "1");
                if("1".equals(str)) break;
            }
            str = str.replaceAll("1", "");
            if("".equals(str)) answer++;
        }
        
        return answer;
    }
}