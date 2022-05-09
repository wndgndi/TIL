10808번 문제​

알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.




import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];   // 알파벳의 입력된 횟수를 넣을 정수 배열
        String s = br.readLine();   // 문자열 입력받음
        char[] ch = s.toCharArray();  // 입력받은 문자열을 문자로 하나씩 ch 인덱스에 넣음

        for(int i=0; i<ch.length; i++)  {  // 문자 배열 ch의 길이만큼 반복
            for(char j='a'; j<='z'; j++) {  // 알파벳 'a'부터 'z'만큼 반복
                int n = j;  // 알파벳을 아스키코드로 받아옴
                if(ch[i] == j) {  // ch 인덱스가 특정 알파벳과 같다면
                    arr[n-97]++;   // 그 알파벳에 해당하는 인덱스의 값 1씩 증가
                }
            }
        }

        for(int i=0; i<26; i++) {    // 알파벳 개수만큼 반복
            System.out.print(arr[i] + " ");  // arr 배열 출력
        }

    }
}