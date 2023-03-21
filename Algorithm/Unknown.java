백준 1764번 듣보잡 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());  // 듣도 못한 사람의 수 정수로 변환
        int m = Integer.parseInt(st.nextToken());  // 보도 못한 사람의 수 정수로 변환

        for(int i=0; i<n; i++) {      // n번만큼 반복
            set.add(br.readLine());   // set에 듣도 못한 사람 이름 넣어줌
        }

        for(int j=0; j<m; j++) {     // m번만큼 반복
            String name = br.readLine();   // 보도 못한 사람의 이름
            if(set.contains(name)) {   // set에 보도 못한 사람 이름이 이미 존재하면,
                list.add(name);   // 리스트에 이름을 넣어줌
            }
        }
        Collections.sort(list);   // 이름을 오름차순 정렬

        bw.write(list.size() + "\n");   // 리스트 크기 출력
        for(int i=0; i<list.size(); i++) {   // 리스트 크기만큼 반복
            bw.write(list.get(i) + "\n");   // 리스트의 i번째 인덱스 출력
        }
        bw.flush();
        bw.close();
    }

}