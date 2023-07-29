import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {        
        int lux = 50, luy = 50, rdx = 0, rdy = 0;
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        
        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}