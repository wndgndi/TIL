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