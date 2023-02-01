Lv1. 가장 가까운 같은 글자 문제

문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.

b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.

문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.


< 코드 Java >

import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        int tmp = -1;
        String[] str = s.split("");  // 문자열을 한글자씩 배열에 넣음
        
        for(int i=s.length()-1; i>0; i--) {   // s의 길이-1만큼 반복
            for(int j=i-1; j>=0; j--) {   // i-1번만큼 반복
                if(str[i].equals(str[j])) {    // str의 i번째 인덱스와 j번째 인덱스 값이 같다면,
                    list.add(i-j);  // 리스트에 i-j 값을 넣어줌
                    tmp = i-j;   // i-j 값을 tmp에 할당
                    break;
                }
            }
            if(tmp == -1) {   // tmp의 값이 -1과 같다면,
                list.add(-1);   // 리스트에 -1을 넣어줌
            }
            tmp = -1;
        }
        list.add(-1);   // 리스트에 -1을 넣음
        Collections.reverse(list);   // 리스트를 뒤집음
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();  // 리스트를 배열로 변환
        
        return answer;
    }
}
