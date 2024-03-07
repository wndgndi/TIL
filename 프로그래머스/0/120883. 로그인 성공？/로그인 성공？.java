import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String password = id_pw[1];
        
        for(int i=0; i<db.length; i++) {            
            String dbId = db[i][0];
            String dbPassword = db[i][1];
            
            if(id.equals(dbId) && password.equals(dbPassword)) {
                return "login";
            } else if(id.equals(dbId) && !password.equals(dbPassword)) {
                return "wrong pw";
            }
        }
        
        return "fail";
    }
}