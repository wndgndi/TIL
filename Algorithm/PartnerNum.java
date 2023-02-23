Lv1. 숫자 짝궁 문제

두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). 
X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 
다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.


< 코드 Java >

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        String[] strx = X.split("");   // 문자열 X 나누어서 배열에 담아줌
        String[] stry = Y.split("");   // 문자열 Y 나누어서 배열에 담아줌
        List<String> list = new ArrayList<>();
        List<String> listx = Arrays.stream(strx).distinct().collect(Collectors.toList());  // 중복 걸러낸 리스트
        List<String> listy = Arrays.stream(stry).distinct().collect(Collectors.toList());  // 중복 걸러낸 리스트
        
        for(int i=0; i<listx.size(); i++) {    // listx의 크기만큼 반복
            if(listy.contains(listx.get(i))) {   // listy에 listx의 짝궁이 있다면,
                int a = Collections.frequency(Arrays.asList(strx), listx.get(i));   // strx에 포함된 해당 정수 개수를 구함
                int b = Collections.frequency(Arrays.asList(stry), listx.get(i));   // stry에 포함된 해당 정수 개수를 구함
                for(int j=0; j<Math.min(a,b); j++) {   // a와 b 중 작은 값이 공통된 개수이므로 그만큼 반복
                    list.add(listx.get(i));  // list에 숫자 짝궁을 넣어줌
                }
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());   // 가장 큰 정수를 만들어야하므로 내림차순 정렬
        
        if(list.size() == 0) {   // list의 크기가 0이면,
            answer = "-1";  // answer은 "-1"이 됨
        } else {   // list의 크기가 0이 아니면,
            StringBuilder sb = new StringBuilder();   
            for(int i=0; i<list.size(); i++) {   // list의 크기만큼 반복
                sb.append(list.get(i));    // sb에 list의 i번 인덱스를 넣어줌
            }
            answer = sb.toString();   // sb를 문자열로 answer에 넣어줌
        }
        
        if(answer.charAt(0) == '0' && answer.charAt(1) == '0') {  // answer의 첫번째, 두번째 숫자 모두 '0'일 경우,
            answer = "0";   // answer은 "0"이 됨
        }
        return answer;   // answer를 반환
    }
}