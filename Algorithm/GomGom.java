백준 25192번 문제

알고리즘 입문방 오픈 채팅방에서는 새로운 분들이 입장을 할 때마다 곰곰티콘을 사용해 인사를 한다. 
이를 본 문자열 킬러 임스는 채팅방의 기록을 수집해 그 중 곰곰티콘이 사용된 횟수를 구해 보기로 했다.

ENTER는 새로운 사람이 채팅방에 입장했음을 나타낸다. 그 외는 채팅을 입력한 유저의 닉네임을 나타낸다. 
닉네임은 숫자 또는 영문 대소문자로 구성되어 있다.

새로운 사람이 입장한 이후 처음 채팅을 입력하는 사람은 반드시 곰곰티콘으로 인사를 한다. 
그 외의 기록은 곰곰티콘을 쓰지 않은 평범한 채팅 기록이다.

채팅 기록 중 곰곰티콘이 사용된 횟수를 구해보자!


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());  
        Set<String> set = new HashSet<>();
        int cnt = 0;

        for(int i=0; i<n; i++) {   // n번 반복
            String name = br.readLine();   // 문자열 입력받음
            if(name.equals("ENTER")) {   // 새로운 사람이 채팅방에 입장했으면,
                cnt += set.size();  // cnt에 곰곰티콘 사용된 횟수 더해줌
                set.clear();  // set을 비워줌
            } else {   // 새로운 사람이 채팅방에 입장하지 않았다면,
                set.add(name);  // 곰곰티콘을 사용한 사람들을 set에 넣어줌
            }
        }
        cnt += set.size();   // cnt에 마지막 들어온 사람에 대한 곰곰티콘 횟수 더해줌

        bw.write(cnt + "\n");   // cnt 출력
        bw.flush();
        bw.close();
    }

}