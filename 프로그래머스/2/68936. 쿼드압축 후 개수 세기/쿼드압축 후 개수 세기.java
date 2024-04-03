class Solution {
    static int[] answer = {0, 0};
    static int[][] area;
    
    public int[] solution(int[][] arr) {        
        area = new int[arr.length][];
        
        for(int i=0; i<arr.length; i++) {
            area[i] = arr[i].clone();
        }

        quad(0, 0, area.length);
        
        return answer;
    }
    
    public void quad(int x, int y, int length) {
        if(compress(x, y, length)) {
            if(area[x][y] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }
        
        quad(x, y, length/2);
        quad(x + length/2, y, length/2);
        quad(x, y + length/2, length/2);
        quad(x + length/2, y + length/2, length/2);
    }
    
    public boolean compress(int x, int y, int length) {
        for(int i=x; i<x+length; i++) {
            for(int j=y; j<y+length; j++) {
                if(area[i][j] != area[x][y]) {
                    return false; 
                }
            }
        }
        return true;
    }
}