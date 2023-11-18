class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++) {
            int cnt = 0;
            for(int j=0; j<targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                int min = Integer.MAX_VALUE;
                int idx = 0;
                for(int k=0; k<keymap.length; k++) {
                    idx = keymap[k].indexOf(c) + 1;
                    if(idx > 0 && idx < min) {
                        min = idx;
                    }
                } 
                if(min == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                cnt += min;
                answer[i] = cnt;
         
            }
            
        }
        return answer;
    }
}