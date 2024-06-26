import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] newMap;
    static boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0; 
        int[] start = new int[3];
        newMap = new char[maps.length][];
        
        for(int i=0; i<maps.length; i++) {
            newMap[i] = maps[i].toCharArray();
        }
        
        for(int i=0; i<newMap.length; i++) {
            for(int j=0; j<newMap[i].length; j++) {
                if(newMap[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                    break;
                } 
            }
        }
        
        int[] lever = bfs(start, 'L');
        if(lever[2] == -1) {
            return -1;
        }
        answer += lever[2];
        
        int[] exit = bfs(new int[]{lever[0], lever[1], 0}, 'E');
        if(exit[2] == -1) {
            return -1;
        }
        
        answer += exit[2];
        
        return answer;
    }
    
    private int[] bfs(int[] start, char c) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[newMap.length][newMap[0].length];
        visited[start[0]][start[1]] = true;
        
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int[] arr = queue.remove();
            boolean chk = false;
            int cnt = arr[2];
            
            for(int i=0; i<4; i++) {
                int y = arr[0] + dy[i];
                int x = arr[1] + dx[i];
                
                if(x >= 0 && y >= 0 && x < newMap[0].length && y < newMap.length
                  && !visited[y][x] && newMap[y][x] != 'X') {
                    visited[y][x] = true;
                    
                    if(newMap[y][x] == c) {
                        return new int[]{y, x, cnt + 1};
                    }
                    queue.add(new int[]{y, x, cnt+1});
                } 
            }
        }
        return new int[]{0, 0, -1};
    }
}
