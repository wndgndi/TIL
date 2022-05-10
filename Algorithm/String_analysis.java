10820번 문제​

문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];   // 소문자, 대문자, 공백, 숫자의 개수를 세기 위한 배열
        String str;

       while((str = br.readLine()) != null) {   // 입력값이 있으면 반복
            char[] ch = str.toCharArray();   // 문자열 str을 하나씩 배열 ch에 넣어줌
            for(int i=0; i<ch.length; i++) {    // 배열 ch의 길이만큼 반복
                if (ch[i] >= 'a' && ch[i] <= 'z') {   // 배열 ch의 인덱스에 소문자가 들어있으면
                    arr[0]++;   // arr의 0번째 인덱스 값을 1씩 증가시킨다
                }
                else if(ch[i] >= 'A' && ch[i] <= 'Z') {   // 배열 ch의 인덱스에 대문자가 들어있으면
                    arr[1]++;   // arr의 1번째 인덱스 값을 1씩 증가시킨다
                }
                else if(ch[i] >= '0' && ch[i]<='9'){   // 배열 ch의 인덱스에 숫자가 들어있으면
                    arr[2]++;   // arr의 2번째 인덱스 값을 1씩 증가시킨다
                }
                else if(ch[i] == ' ') {    // a배열 ch의 인덱스에 공백이 들어있으면
                    arr[3]++;   // arr의 3번째 인덱스 값을 1씩 증가시킨다
                }

            }
           for(int k=0; k<4; k++) {   // 4번 반복
               System.out.print(arr[k] + " ");   //  문자열을 분석한 결과를 출력
               arr[k]=0;   // 배열의 값들을 다시 0으로 만들어줌
           }
           System.out.println(); // 개행

        }

    }
}