백준 20920번 문제

화은이는 이번 영어 시험에서 틀린 문제를 바탕으로 영어 단어 암기를 하려고 한다. 그 과정에서 효율적으로 영어 단어를 외우기 위해 영어 단어장을 만들려 하고 있다. 
화은이가 만들고자 하는 단어장의 단어 순서는 다음과 같은 우선순위를 차례로 적용하여 만들어진다.

1. 자주 나오는 단어일수록 앞에 배치한다.
2. 해당 단어의 길이가 길수록 앞에 배치한다.
3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 
M보다 짧은 길이의 단어의 경우 읽는 것만으로도 외울 수 있기 때문에 길이가 
M이상인 단어들만 외운다고 한다. 화은이가 괴로운 영단어 암기를 효율적으로 할 수 있도록 단어장을 만들어 주자.


< Java 코드 >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {    // n번 반복
            String voca = br.readLine();  // 단어 입력
            int cnt = map.getOrDefault(voca, 0);  // 단어의 빈도
            if(voca.length() >= m) {   // 단어 길이가 m 이상이면,
                map.put(voca, cnt+1);   // map에 단어와 빈도수 입력
            }
        }

        List<String> list = new ArrayList<>(map.keySet());  // map을 리스트로 변환

        list.sort((o1, o2) -> {  // 다중 조건 정렬
            int a = map.get(o1);  // 단어 o1의 빈도 수
            int b = map.get(o2);  // 단어 o2의 빈도 수

            if(a == b) {   // 두 단어의 빈도 수가 같다면,
                if(o1.length() == o2.length()) return o1.compareTo(o2); // 길이가 같다면, 사전순으로 정렬
                return o2.length()-o1.length();  // 단어가 길수록 앞에 배치
            }
            return b-a;  // 단어의 빈도가 높을 수록 앞에 정렬
        });

        List<String> note = list.stream().distinct().collect(Collectors.toList());  // 중복 제거

        for(int i=0; i<note.size(); i++) {  // note의 크기만큼 반복
            bw.write(note.get(i) + "\n");  // 단어장의 단어 출력
        }
        bw.flush();
        bw.close();
    }

}
