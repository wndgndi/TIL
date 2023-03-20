import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());  // 문자열 토큰으로 입력받음
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());  // 포켓몬 개수 정수로 변환 
        int m = Integer.parseInt(st.nextToken());  // 문제 개수 정수로 변환

        String[] arr = new String[n];  // 포켓몬 번호로 이름을 찾기 위한 배열

        for(int i=0; i<n; i++) {   // n번만큼 반복
            String pokemon = br.readLine();   // 포켓몬 이름 입력받음
            map.put(pokemon, i+1);   // 포켓몬 이름과 번호 맵핑하여 넣어줌
            arr[i] = pokemon;   // 배열에 포켓몬 넣어줌
        }

        for(int i=0; i<m; i++) {   // m번 반복
            String quiz = br.readLine();   // 문제 입력받음
            if(quiz.matches("^[a-zA-z]*$")) {   // 문제가 포켓몬 이름(영어)일 경우,
                bw.write(map.get(quiz) + "\n");   // 포켓몬 번호를 출력
            } else {       // 문제가 포켓몬 번호일 경우,
                int cnt = Integer.parseInt(quiz);  // 문자열로 입력받았으므로 정수로 변환
                bw.write(arr[cnt-1] + "\n");   // 해당 번호에 맵핑된 포켓몬 이름 출력
            }

        }

        bw.flush();
        bw.close();
    }

}