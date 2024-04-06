class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int end = attacks[attacks.length-1][0];
        int max = health;
        int idx = 0;
        int term = 0;

        for(int i=1; i<=end; i++) {
            if(i == attacks[idx][0]) {
                health -= attacks[idx][1];
                term = 0;
                idx++;
            } else {
                health += bandage[1];
                term++;
                if(term == bandage[0]) {
                    health+= bandage[2];
                    term = 0;
                }
            }
            
            if(health > max) {
                health = max;
            } else if(health <= 0) {
                return -1;
            }
        }
        
        return health;
    }
}