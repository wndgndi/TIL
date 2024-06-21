import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] newBoard;
    
    public int solution(String[] board) {
        int answer = 0;
        int[] start = new int[2];
        newBoard = new String[board.length][];
        
        loop:
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                    break loop;
                } 
            }
        }
        
        for(int i=0; i<board.length; i++) {
            String[] str = board[i].split(""); 
            newBoard[i] = str;
        }
        
        answer = bfs(start);
    

        return answer;
    }
    
    private int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[newBoard.length][newBoard[0].length];
        visited[start[0]][start[1]] = true;
        queue.add(new int[]{start[0], start[1], 0});

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cnt = arr[2];
            
            if("G".equals(newBoard[arr[0]][arr[1]])) {
                return cnt;
            }
            
            for(int i=0; i<4; i++) {
                int x = arr[1];
                int y = arr[0];
                
                while(y + dy[i] >= 0 && x + dx[i] >= 0 && 
                     y + dy[i] < newBoard.length && x + dx[i] < newBoard[0].length
                     && !"D".equals(newBoard[y+dy[i]][x+dx[i]])) {
                    y += dy[i];
                    x += dx[i];
                }
                
                if(!visited[y][x]) {
                    visited[y][x] = true;
                    queue.add(new int[]{y, x, cnt+1});
                }
            }
        }     
        return -1;
    }
    
}