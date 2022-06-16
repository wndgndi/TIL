2869번 문제풀기

땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 
미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.


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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
				
		int day = (length - down)/ (up - down);
		if((length-down)%(up-down) != 0) {
			day++;
		}	
		bw.write(day+"\n");
		bw.flush();
		bw.close();
	}
}


시간 제한이 있기 때문에 처리 속도가 더 빠른 Buffered Reader/ Writer 를 사용하였다.

-  입력 받을수 있도록 BufferedReader와 BufferedWriter를 선언해준다.

-  br.readLine( )은 문자열로 데이터를 받으므로 String을 int 타입으로 변환시켜준다.

-  달팽이가 올라가는 규칙 (공식)을 구한다.

달팽이가 하루동안 올라가는 실제 높이는 up - down 이라고 볼 수 있다.
높이에서 (up - down)만큼을 나눴을 때 나머지가 존재한다면 일수에 1을 더해줘야 한다.
하지만, length /(up - down) 사용했을 때  (up-down) = 1경우 걸리는 일수의 결과값이 다르게 나온다. 
