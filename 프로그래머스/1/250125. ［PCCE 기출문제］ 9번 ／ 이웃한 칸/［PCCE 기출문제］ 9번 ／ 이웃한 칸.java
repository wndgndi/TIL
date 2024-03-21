class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i=0; i<4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];
            
            if(x >= 0 && y >= 0 && x < board[h].length && y < board.length) {
                if(board[x][y].equals(board[h][w])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}