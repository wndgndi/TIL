11656번 문제풀이

접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.​



import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();
        String str = br.readLine();
        String[] arr = new String[str.length()];
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {    // 문자배열 ch의 길이만큼 반복
            list.add(ch[i]);    // 배열ch의 i번 인덱스를 list 에 넣어줌
        }

        int n = list.size();      // 정수 n은 list의 채워져있는 크기와 같음

        for (int i = 0; i < list.size(); ) {     // list의 채워진 크기만큼 반복
            for (int j = 0; j < list.size(); j++) {     // list의 채워지 크기만큼 반복
                sb.append(list.get(j));     // list의 j번째 인덱스를 sb에 하나씩 넣어서 문자열로 만들어줌
            }
            arr[list.size()-1] = sb.toString();  //  위에서 만든 문자열 sb를 배열 arr에 하나씩 넣어줌
            sb.setLength(0);   // sb의 길이를 다시 0으로 초기화해줌
            list.remove(0);    // list의 0번 인덱스를 지워줌
        }

        Arrays.sort(arr);   // 배열 arr을 오름차순으로 정렬

        for (int i = 0; i < arr.length; i++) {   // arr의 길이만큼 반복함
            bw.write(arr[i] + "\n");    // arr의 i번째 배열을 출력
        }
        bw.flush();
        bw.close();
    }
} 