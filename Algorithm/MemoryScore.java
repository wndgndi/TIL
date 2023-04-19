Lv1. 추억 점수 문제풀이

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i=0; i<photo.length; i++) {   // photo의 길이만큼 반복
            int sum = 0;  // sum을 초기화
            for(int j=0; j<photo[i].length; j++) {  // photo의 i열 길이만큼 반복
                for(int k=0; k<name.length; k++) {  // name의 길이만큼 반복
                    if(photo[i][j].equals(name[k])) {   // 사진 속 인물의 그리움 점수가 있다면,
                        sum += yearning[k];  // 해당 점수만큼 sum에 더해줌
                    }
                }
            }
            answer[i] = sum;   // 추억 점수를 answer 배열에 넣어줌
        }
        
        return answer;   // answer를 반환
    }
}
