import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {	
		   Scanner sc = new Scanner(System.in);
		   int test = sc.nextInt();
		   int[][] arr = new int[15][15];  // 1 <= k,n <= 14 이므로 배열의 크기를 15로 한다
		   
		   for(int i=0; i<15; i++) {
				   arr[0][i] = i;   // 0층은 1,2,3,4,..,15로 i값과 동일하다
				   arr[i][1] = 1;   // 1호 라인은 모두 값이 1이다
		   }
			
		   for(int i=1; i<15; i++) {   
			   for(int j=2; j<15; j++)
					   arr[i][j] = arr[i][j-1] + arr[i-1][j];  // 거주민수 구하는 공식
				   }
					   	   
		for(int i=0; i<test; i++) {
			int k = sc.nextInt();   // 층수 입력
			int n = sc.nextInt();	// 호수 입력 			 
			   	   
		System.out.println(arr[k][n]);   // k층, n호에 사는 거주민수 출력
		}
	  }
}