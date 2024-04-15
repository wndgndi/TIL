import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][];
        dp[0] = land[0];
        
        for(int i=1; i<land.length; i++) {
            dp[i] = new int[land[i].length];
        }
                
        for(int i=0; i<land.length-1; i++) {
            for(int j=0; j<land[i].length; j++) {
                for(int k=0; k<land[i].length; k++) {
                    if(j != k) {
                        if(dp[i+1][k] == 0) {
                            dp[i+1][k] = dp[i][j] + land[i+1][k];
                        } else {
                            dp[i+1][k] = Math.max(dp[i+1][k], dp[i][j] + land[i+1][k]);
                        }
                    }
                }
            }
        }
        Arrays.sort(dp[dp.length-1]);

        return dp[dp.length-1][dp[dp.length-1].length-1];
    }
}