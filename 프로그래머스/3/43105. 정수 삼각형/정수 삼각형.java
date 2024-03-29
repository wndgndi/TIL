import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] max = new int[triangle.length][];
        
        for(int i=0; i<triangle.length; i++) {
            max[i] = new int[triangle[i].length];
        }
        max[0][0] = triangle[0][0];
        
        for(int i=0; i<triangle.length-1; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(max[i+1][j] == 0) {
                    max[i+1][j] += max[i][j] + triangle[i+1][j];
                } else {
                    max[i+1][j] = Math.max(max[i+1][j], max[i][j] + triangle[i+1][j]);
                }
                max[i+1][j+1] = max[i][j] + triangle[i+1][j+1];
            }
        }
        
        Arrays.sort(max[max.length-1]);
        
        return max[max.length-1][max[max.length-1].length-1];
    }
}