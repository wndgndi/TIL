class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        for(int i=0; i<queries.length; i++) {
            StringBuilder sb = new StringBuilder();

            String a = my_string.substring(0, queries[i][0]);
            String b = my_string.substring(queries[i][0], queries[i][1] + 1);
            String c = "";
            
            if(queries[i][1] < my_string.length() - 1) {
                c = my_string.substring(queries[i][1] + 1, my_string.length());
            }
            
            b = sb.append(b).reverse().toString();
            sb = new StringBuilder();
            my_string = sb.append(a).append(b).append(c).toString();
        }
    
        return my_string;
    }
}