
Lv0. 키패드 누르기 문제풀이

< Java 코드 >

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String left = "30";   // 왼손 시작점 '*'의 위치
        String right = "32";  // 오른손 시작점 '#'의 위치
        Map<Integer, String> map = new HashMap<>();
        
        map.put(1, "00");
        map.put(2, "01");
        map.put(3, "02");
        map.put(4, "10");
        map.put(5, "11");
        map.put(6, "12");
        map.put(7, "20");
        map.put(8, "21");
        map.put(9, "22");
        map.put(0, "31");
        // map에 키패드를 키, 위치를 값으로 넣어줌

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++) {   // numbers의 길이만큼 반복
            int num = numbers[i];   // numbers의 i번 인덱스를 num으로 변수 선언, 초기화
                      
            if(num == 1 || num == 4 || num == 7) {   // num이 1이나 4나 7이라면,
                left = map.get(num);   // 왼손을 해당 키패드 위치로 초기화
                sb.append("L");   // sb에 "L"을 넣어줌
            } else if(num == 3 || num == 6 || num == 9) {  // num이 3이나 6이나 9라면,
                right = map.get(num);  // 오른손을 해당 키패드 위치로 초기화
                sb.append("R");  // sb에 "R"을 넣어줌
            } else if(num == 2 || num == 5 || num == 8 || num == 0) {   // num이 2나 5나 8이나 0이라면,
                String[] position = map.get(num).split("");  // 문자열을 쪼개서 배열에 넣어줌
                int a = Integer.parseInt(position[0]);  // position의 행 위치 정수로 변환
                int b = Integer.parseInt(position[1]);  // position의 열 위치 정수로 변환

                String[] leftHand = left.split("");   // 문자열을 쪼개서 배열에 넣어줌
                int la = Integer.parseInt(leftHand[0]);   // 왼손 행 위치 정수로 변환
                int lb = Integer.parseInt(leftHand[1]);   // 왼손 열 위치 정수로 변환
                
                String[] rightHand = right.split("");  // 문자열 쪼개서 배열에 넣어줌
                int ra = Integer.parseInt(rightHand[0]);  // 오른손 행 위치 정수로 변환
                int rb = Integer.parseInt(rightHand[1]);  // 오른손 열 위치 정수로 변환
                
                if(Math.abs(a-la) + Math.abs(b-lb) > Math.abs(a-ra) + Math.abs(b-rb)) {  // 오른손이 왼손보다 패드에 더 가깝다면,
                    right = map.get(num);  // 오른손을 해당 키패드 위치로 초기화
                    sb.append("R");  // sb에 "R"을 넣어줌
                } else if(Math.abs(a-la) + Math.abs(b-lb) == Math.abs(a-ra) + Math.abs(b-rb)) {  // 패드에서 오른손, 왼손의 거리가 같다면,
                    if(hand.equals("right")) {   // 오른손잡이일 경우, 
                        right = map.get(num);  // 오른손을 해당 키패드 위치로 초기화
                        sb.append("R");  // sb에 "R"을 넣어줌
                    } else {   // 왼손잡이일 경우,
                        left = map.get(num);  // 왼손을 해당 키패드 위치로 초기화
                        sb.append("L");   // sb에 "L"을 넣어줌
                    }
                } else {   // 왼손이 오른손보다 패드에 더 가깝다면,
                     left = map.get(num);  // 왼손을 해당 키패드 위치로 초기화
                     sb.append("L");   // sb에 "L"을 넣어줌
                }
            }
        }
        
        answer = sb.toString();   // answer를 sb로 초기화
        return answer;  // answer를 반환
    }
}
