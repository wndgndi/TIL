import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        String[][] wallpapers = new String[wallpaper.length][wallpaper[0].length()];
        
        for(int i=0; i<wallpapers.length; i++) {
            wallpapers[i] = wallpaper[i].split("");
        }
        
        int lux = -1, luy = 50, rdx = 0, rdy = 0;
        
        for(int i=0; i<wallpapers.length; i++) {
            for(int j=0; j<wallpapers[i].length; j++) {
                if(wallpapers[i][j].equals("#")) {
                    if(lux == -1) {
                        lux = i;
                    }
                    if(j < luy) {
                        luy = j;
                    }
                    if(i > rdx) {
                        rdx = i;
                    }
                    if(j > rdy) {
                        rdy = j;
                    }
                }
            }
        }
        
        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}