class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width = (brown - 2) / 2;
        int length = 1;
        
        while(true) {
            if((width - 2) * length == yellow) {
                answer[0] = width;
                answer[1] = length + 2;
                break;
            } else {
                width--;
                length++;
            }
        }

        return answer;
    }
}