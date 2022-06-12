import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {	
		   Scanner sc = new Scanner(System.in);
		   int sugar = sc.nextInt();
		   int bag = 0;
		   
		   loop :       // loop를 통해 break으로 빠져나올 위치 지정
		   for(int i=0; i<=sugar/3; i++) {   // 3킬로 봉지가 차선
			   for(int j=0; j<=sugar/5; j++) {    // 5킬로 봉지가 최선
				  if(sugar == 5*j + 3*i) {    // 봉지의 개수와 일치할 시
					  bag = i+j;	// 위에서 구한 3키로 봉지와 5키로 봉지를 더함					  
					  break loop;
				 }
				  else {     // 3, 5키로 봉지로 설탕 무게를 맞출 수 없는 경우
					  bag = -1;
				  }
			   }
		   	 }		
		   System.out.println(bag);
	  }
}
