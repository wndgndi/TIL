Lv1. 행렬의 덧셈 문제

행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 
2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        for(int i=0; i<arr1.length; i++) {   // arr1의 길이만큼 반복
            for(int j=0; j<arr1[i].length; j++) {   // arr1의 i번째 인덱스 길이만큼 반복
                answer[i][j] += arr1[i][j] + arr2[i][j];   // arr1과 arr2를 더함
            }
        }
        
        return answer;    // answer 반환
    }
}
