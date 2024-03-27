import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        
        if(board.length == 1) {
            if(board[0][0] == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 1) {
                    for(int k=0; k<3; k++) {
                        for(int l=0; l<3; l++) {
                            int a = i + dx[k];
                            int b = j + dy[l];
                            
                            if(a >= 0 && b >= 0 && a < board.length && b < board.length) {
                                if(board[a][b] != 1) {
                                    board[a][b] = 2;
                                }
                            }
                        }
                    }
                }
            }
        }
           
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}