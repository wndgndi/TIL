Lv1. 최소 직사각형 문제

명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 
이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.


< 코드 1 >

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int tmp = 0;
        int row = 0;
        int col = 0;
        
        for(int i=0; i<sizes.length; i++) {     // sizes의 길이만큼 반복
            if(sizes[i][0] < sizes[i][1]) {     // 가로 길이가 세로 길이보다 작다면,
                tmp = sizes[i][0];   // 가로 길이를 tmp에 임시 저장
                sizes[i][0] = sizes[i][1];    // 가로 길이에 세로 길이를 넣어줌
                sizes[i][1] = tmp;   // 세로 길이에 임시저장 했던 가로 길이를 넣어줌
            }
        }        
        for(int i=0; i<sizes.length; i++) {   // sizes의 길이만큼 반복
            if(sizes[i][0] > col) {    // 가로 길이가 col보다 크다면,
                col = sizes[i][0];   // col에 해당 가로 길이를 넣어줌
            }
            if(sizes[i][1] > row) {   // 세로 길이가 row보다 크다면,
                row = sizes[i][1];    // row에 해당 세로 길이를 넣어줌
            }
        }        
        answer = col*row;   // answer에 col과 row를 곱한 값을 넣어줌
                
        return answer;    // answer를 반환
    }
}


< 코드 2 >

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;  // 최대 가로 길이를 구하기 위한 변수
        int height = 0;  // 최대 세로 길이를 구하기 위한 변수
        
        for(int[] size: sizes) {   // sizes의 길이만큼 반복
            width = Math.max(width, Math.max(size[0], size[1]));  // 가로, 세로 길이를 비교하여 더 큰 값을 width로 넣어줌
            height = Math.max(height, Math.min(size[0], size[1]));  // 가로, 세로 길이를 비교하여 더 작은 값을 hegith으로 넣어줌
        }
        answer = width * height;    // width와 height을 곱한 값을 answer에 넣어줌
        
        return answer;     // asnwer를 반환
    }
}
