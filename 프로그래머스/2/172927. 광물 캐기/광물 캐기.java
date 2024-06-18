class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {    
        backtracking(picks, minerals, 0, 0);
        return answer;
    }
    
    private void backtracking(int[] picks, String[] minerals, int fatigue, int idx) {  
        if (fatigue >= answer) return;

        boolean allUsed = true;
        
        for(int pick:picks) {
           if(pick != 0) {
               allUsed = false;
               break;
           } 
        }
        
        if(allUsed || idx >= minerals.length) {
            answer = Math.min(answer, fatigue);
            return;
        }
        
        for(int i=0; i<picks.length; i++) {
            if(picks[i] == 0) {
                continue;
            }
            int fatigue2 = fatigue;
            int fin = Math.min(idx + 5, minerals.length);
            
            for(int j=idx; j<fin; j++) {
                if(i == 0) {
                    fatigue2++;
                } else if(i == 1) {
                    if("diamond".equals(minerals[j])) fatigue2 += 5;
                    else fatigue2++;
                } else {
                    if("diamond".equals(minerals[j])) fatigue2 += 25;
                    else if("iron".equals(minerals[j])) fatigue2 += 5;
                    else fatigue2++;
                }
            }
            picks[i]--;
            backtracking(picks, minerals, fatigue2, fin);
            picks[i]++;
        }
    }
}