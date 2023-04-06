백준 7785번 문제

상근이는 세계적인 소프트웨어 회사 기글에서 일한다. 이 회사의 가장 큰 특징은 자유로운 출퇴근 시간이다. 
따라서, 직원들은 반드시 9시부터 6시까지 회사에 있지 않아도 된다.

각 직원은 자기가 원할 때 출근할 수 있고, 아무때나 퇴근할 수 있다.

상근이는 모든 사람의 출입카드 시스템의 로그를 가지고 있다. 이 로그는 어떤 사람이 회사에 들어왔는지, 나갔는지가 기록되어져 있다. 
로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.


< 코드 Java >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());   // 출입 기록
        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {   // n번 반복
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();   // 이름
            String commute = st.nextToken();   // 출퇴근 여부

            if(commute.equals("enter")) {   // 출근했으면,
                set.add(name);  // 회사에 있음
            } else if(commute.equals("leave")) {   // 퇴근했으면,
                set.remove(name);   // 회사에 없음
            }
        }
        set.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); 
        // 회사에 있는 인원 역순 정렬 후 출력

    }

}
