import java.util.Scanner;

public class Main {
	   public static void main(String[] args)   {	
		  Scanner sc = new Scanner(System.in);
		 
		  int[] x = new int[3];   // 입력받은 x 값을 담을 배열
		  int[] y = new int[3];   // 입력받은 y 값을 담을 배열
		  int x4, y4;    // 네 번째 좌표 변수 선언
		  
		  for(int i=0; i<3; i++) {
			  x[i] = sc.nextInt();
			  y[i] = sc.nextInt();
		  }
		  
		 if(x[0] == x[1]) {
			 x4 = x[2];
		 }
		 else {
			x4 = (x[0] == x[2])? x[1]:x[0];
		 }
		 
	   	 if(y[0] == y[1]) {
	   		 y4 = y[2];
	   	 }
	   	 else {
	   		 y4 = (y[0] == y[2]) ? y[1]:y[0];
	   	 }
	   	 
	   	 System.out.println(x4 + " " + y4);
	   }
}	