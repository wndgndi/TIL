15828번 문제

인터넷을 사용하기 위해서는 컴퓨터에 인터넷 회선을 연결하거나 Wi-Fi를 연결해야 한다. 이렇게 연결된 네트워크를 통해 컴퓨터에는 통신이 가능하다. 
마음에 드는 노래나 동영상이 있는 곳에 파일을 전송해달라는 요청을 보내고 파일을 받는 식으로 말이다.
우리가 보낸 요청은 어떻게 목적지까지 도달하는 것일까? 컴퓨터에서는 패킷이라고 하는 형태로 정보를 주고 받는다. 
네트워크의 유저들은 1:1로 연결되어 있지 않으므로, 일반적으로 패킷은 라우터라는 장비를 여러 번 거친다. 그러면 라우터에서는 패킷을 다른 라우터로 보내거나, 
만약 목적지와 직접적으로 연결되어 있다면 그곳으로 보낼 수도 있다. 즉, 택배 회사의 물류 센터와 비슷한 역할을 한다고 보면 된다.


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int size = Integer.parseInt(br.readLine());   // 큐의 크기를 위한 변수
        int n = 0;   // 입력받는 패킷을 위한 변수

        while (true) {   // 계속 반복
            n = Integer.parseInt(br.readLine());   // n을 입력받음
            int a = queue.size();   // 큐의 크기를 변수 a에 넣어줌
            if (n == -1) {   // n이 -1일 경우,
                for (int i = 0; i < a; i++) {    // a만큼 반복
                    list.add(queue.poll());    // 리스트에 큐의 값을 넣어줌
                }
                break;   // 반복문 탈출
            } else if (queue.size() < size && n > 0) {   // 현재 큐의 크기가 할당된 크기보다 작고 n이 0보다 크면,
                queue.add(n);    // 큐에 n을 넣어줌
            } else if (n == 0) {   // n이 0일 경우,
                queue.poll();   // 큐에서 값을 제거함
            }

        }

        if (list.size() > 0) {     // 리스트 크기가 0보다 클 경우,
            for (int i = 0; i < list.size(); i++) {    // 리스크 크기만큼 반복
                if (i < list.size() - 1) {   // i가 리스트 크기-1보다 작을 경우,
                    System.out.print(list.get(i) + " ");   // 리스트의 i번째 인덱스와 공백을 출력
                } else {   // i가 리스트 크기-1과 같을 경우,
                    System.out.print(list.get(i));   // 리스트의 i번째 인덱스를 출력
                }
            }
        } else {   // 리스트 크기가 0인 경우,
            System.out.println("empty");   // "empty"를 출력
        }

    }

}
