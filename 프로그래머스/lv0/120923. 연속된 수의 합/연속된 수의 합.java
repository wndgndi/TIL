class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int check = total/num;
        int side = (int) num/2;
        int start = 0;
        
        if(num%2 != 0) {
            start =  check - side;
        } else {
            start = check - side + 1;
        }
                       
        for(int i=0; i<num; i++) {
            answer[i] = start;
            start++;
        }
        
        return answer;
    }
}