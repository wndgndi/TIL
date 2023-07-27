import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>() {
            {
                put("A", 0);
                put("N", 0);
                put("C", 0);
                put("F", 0);
                put("M", 0);
                put("J", 0);
                put("R", 0);
                put("T", 0);
            }
        };
        
        for(int i=0; i<survey.length; i++) {
            String[] types = survey[i].split("");
            String type1 = types[0];
            String type2 = types[1];
            int score = getScore(choices[i]);
       
            if(choices[i] < 4) {
                map.put(type1, map.get(type1) + score);
            } else if(choices[i] > 4) {
                map.put(type2, map.get(type2) + score);
            } 
       }

        answer = getType(map);
        return answer;
    }
    
     public int getScore(int choice) {
        if(choice == 1 || choice == 7) {
            return 3;
        } else if(choice == 2 || choice == 6) {
            return 2;
        } else if(choice == 3 || choice == 5) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public String getType(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        
        if(map.get("R") > map.get("T")) {
            sb.append("R");
        } else if(map.get("T") > map.get("R")) {
            sb.append("T");
        } else {
            sb.append("R");
        }
        
        if(map.get("C") > map.get("F")) {
            sb.append("C");
        } else if(map.get("F") > map.get("C")) {
            sb.append("F");
        } else {
            sb.append("C");
        }
        
        if(map.get("J") > map.get("M")) {
            sb.append("J");
        } else if(map.get("M") > map.get("J")) {
            sb.append("M");
        } else {
            sb.append("J");
        }
        
        if(map.get("A") > map.get("N")) {
            sb.append("A");
        } else if(map.get("N") > map.get("A")) {
            sb.append("N");
        } else {
            sb.append("A");
        }
        return sb.toString();
    }
}