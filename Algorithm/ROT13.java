11655번 문제

ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
예를 들어, "Baekjoon Online Judge"를 ROT13으로 암호화하면 "Onrxwbba Bayvar Whqtr"가 된다. ROT13으로 암호화한 내용을 원래 내용으로 바꾸려면 암호화한 문자열을 다시 ROT13하면 된다. 앞에서 암호화한 문자열 "Onrxwbba Bayvar Whqtr"에 다시 ROT13을 적용하면 "Baekjoon Online Judge"가 된다.
ROT13은 알파벳 대문자와 소문자에만 적용할 수 있다. 알파벳이 아닌 글자는 원래 글자 그대로 남아 있어야 한다. 예를 들어, "One is 1"을 ROT13으로 암호화하면 "Bar vf 1"이 된다.
문자열이 주어졌을 때, "ROT13"으로 암호화한 다음 출력하는 프로그램을 작성하시오.




import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();  // 문자열 str을 입력받음
        char[] ch = str.toCharArray();   // 배열 ch에 문자열 str을 하나씩 넣어줌
 
        for(int i=0; i<ch.length; i++) {     // 배열 ch 길이만큼 반복
            if (ch[i] >= 'A' && ch[i] <= 'Z' ) {   // ch[i]가 대문자인 경우
                if(ch[i]+13 > 'Z') {     // ch[i]+13이 'Z'보다 크다면
                    sb.append((char)(ch[i]-13));  //  ch[i]에서 13을 뺀 값을 sb에 더해줌
                }
                else{    // ch[i]+13이 'Z'보다 크지 않다면
                    sb.append((char)(ch[i]+13));  //  ch[i]에서 13을 더한 값을 sb에 더해줌
                }
            }
            else if(ch[i] >= 'a' && ch[i] <= 'z') {  // ch[i]가 소문자인 경우
                if(ch[i]+13 > 'z') {    // ch[i]+13이 'z'보다 크다면
                    sb.append((char)(ch[i]-13));    // ch[i]에서 13을 뺀 값을 sb에 더해줌
                }
                else {    // ch[i]+!3이 'z'보다 작다면
                    sb.append((char)(ch[i]+13));  // ch[i]에서 13을 더한 값을 sb에 더해줌
                }
            }
            else{   // 대문자, 소문자가 아닌 경우
                sb.append(ch[i]);  // 그대로 sb에 더해줌
            }
        }

        bw.write(sb.toString() + "\n");   // sb를 출력
        bw.flush();
        bw.close();
    }
}