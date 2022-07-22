import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");  // 입력받은 문자열을 나눠서 배열 str에 넣어줌
        Arrays.sort(str, Collections.reverseOrder());  // 배열 str을 내림차순으로 정렬

        for(int i=0; i<str.length; i++) {  // str의 길이만큼 반복
            System.out.print(str[i]);  // str의 i번째 인덱스를 출력해준다
        }
    }
}