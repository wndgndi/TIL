Lv1. 완주하지 못한 선수 문제

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.


< 코드 Java >

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> answerMap = new HashMap<>();
        
        for(int i=0; i<participant.length; i++) {   // 참여한 선수들 수만큼 반복
            String name = participant[i];  // 참여한 i번째 인덱스 선수의 이름으로 초기화
            if(answerMap.containsKey(name)) {   // 해당 선수 이름을 키로 가지고 있으면,
                int count = answerMap.get(name);   // 키에 해당하는 값을 넣어줌
                answerMap.put(name, count+1);  // answerMap에 키로 선수 이름, 값을 1 증가시킴
            } else {  // 해당 선수의 이름을 키로 가지고 있지 않으면,
                answerMap.put(name, 1);   // 이름을 키로 넣고, 값으 1로 넣어줌
            }
        }
        
        for(int i=0; i<completion.length; i++) {   // 완주한 선수들 수만큼 반복
            String name = completion[i];   // 완주한 i번째 인덱스 선수의 이름으로 초기화
            int count = answerMap.get(name);  // 선수 이름의 키에 대한 값으로 초기화
            
            if(count == 1) {   // count가 1이라면,
                answerMap.remove(name);   // 해당 선수를 지움
            } else {   // count가 1이 아니라면,
                answerMap.put(name, count-1);   // 해당 선수의 값에서 1을 빼줌 
            }
        }
        
        answer = answerMap.keySet().iterator().next();   // 남아있는 이름을 넣어줌  
        return answer;   // answer를 반환
    }
}
