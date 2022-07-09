import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;  
		
		int a = Integer.parseInt(br.readLine());   // readLine()으로 입력받은 문자열을 정수로 변환
		
			
		for(int i=0; i<a; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
		}
		br.close();   // BufferedReader 스트림을 종료함
		
		bw.flush();  // 남아있는 데이터를 모두 출력
		bw.close();  // BufferedWriter 스트림을 종료함
	}
}   