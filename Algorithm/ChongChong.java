백준 26069번 문제

총총이는 친구 곰곰이의 소개로 제2회 곰곰컵에 출연할 기회를 얻었다!

총총이는 자신의 묘기인 무지개 댄스를 선보여, 여러분의 환심을 사려 한다. 
이 댄스는 중독성이 강하기 때문에, 한번 보게 된 사람은 모두 따라 하게 돼버린다.

사람들이 만난 기록이 시간 순서대로 N개 주어진다. (총총이는 토끼이지만 이 문제에서는 편의상 사람이라고 가정한다.)

무지개 댄스를 추지 않고 있던 사람이 무지개 댄스를 추고 있던 사람을 만나게 된다면, 만난 시점 이후로 무지개 댄스를 추게 된다.

기록이 시작되기 이전 무지개 댄스를 추고 있는 사람은 총총이 뿐이라고 할 때, 마지막 기록 이후 무지개 댄스를 추는 사람이 몇 명인지 구해보자!


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");   // 총총이를 미리 넣어놓음

        for(int i=0; i<n; i++) {   // n번 반복
            st = new StringTokenizer(br.readLine());

            String name1 = st.nextToken();   // 첫번째 이름
            String name2 = st.nextToken();   // 두번째 이름
 
            if(set.contains(name1)) {   // 첫번째 사람이 총총이거나, 총총이를 만났다면
                set.add(name2);  // 두번째 사람도 set에 넣어줌
            } else if(set.contains(name2)) {   // 두번째 사람이 총총이거나, 총총이를 만났다면
                set.add(name1);   // 첫번째 사람도 set에 넣어줌
            }
        }

        bw.write(set.size() + "\n");   // set의 크기를 출력
        bw.flush();
        bw.close();
    }

}
