class Solution {
    public int[] solution(String myString) {
        String[] tmp = myString.split("x");
        int[] answer;
        
        if(myString.charAt(myString.length()-1) == 'x') {
            answer = new int[tmp.length+1];
        } else {
            answer = new int[tmp.length];
        }
        
        for(int i=0; i<tmp.length; i++) {
            answer[i] = tmp[i].length();
        }
        
        return answer;
    }
}